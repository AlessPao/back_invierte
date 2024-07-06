package com.invertir.ya.service.impl;

import com.invertir.ya.model.Article;
import com.invertir.ya.repo.IArticleRepo;
import com.invertir.ya.repo.IGenericRepo;
import com.invertir.ya.service.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends CRUDImpl<Article, Integer> implements IArticleService
{

    private final IArticleRepo repo;
    @Override
    protected IGenericRepo<Article, Integer> getRepo() {
        return repo;
    }

    @Override
    public Article save(Article article) {
        article.setCreatedAt(LocalDateTime.now());
        return super.save(article);
    }

    @Override
    public Article update(Article article, Integer integer)
    {
        Article articleFound = repo.findById(integer).orElseThrow(()->new RuntimeException("Article not found"));
        article.setCreatedAt(articleFound.getCreatedAt());
        return super.update(article, integer);
    }

    @Override
    public List<Article> saveAll(List<Article> t) throws Exception {
        repo.deleteAll();
        t.forEach(article -> article.setCreatedAt(LocalDateTime.now()));
        return repo.saveAll(t);
    }
}
