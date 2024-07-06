package com.invertir.ya.service;

import com.invertir.ya.model.Article;

import java.util.List;

public interface IArticleService extends ICRUD<Article, Integer>
{
    List<Article> saveAll(List<Article> t) throws Exception;
}
