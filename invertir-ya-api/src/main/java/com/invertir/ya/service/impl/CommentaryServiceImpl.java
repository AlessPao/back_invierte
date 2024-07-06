package com.invertir.ya.service.impl;

import com.invertir.ya.model.Commentary;
import com.invertir.ya.repo.ICommentaryRepo;
import com.invertir.ya.repo.IGenericRepo;
import com.invertir.ya.service.ICommentaryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentaryServiceImpl extends CRUDImpl<Commentary, Integer> implements ICommentaryService
{
    private final ICommentaryRepo repo;
    @Override
    protected IGenericRepo<Commentary, Integer> getRepo() {
        return repo;
    }

    @Override
    public Commentary save(Commentary commentary) {
        commentary.setCreatedAt(LocalDateTime.now());
        return super.save(commentary);
    }

    @Transactional
    @Override
    public void delete(Integer integer) {
        System.out.println("Deleting commentary with id: " + integer);
       repo.deleteById(integer);
    }
}
