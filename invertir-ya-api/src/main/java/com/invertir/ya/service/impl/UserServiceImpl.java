package com.invertir.ya.service.impl;

import com.invertir.ya.dto.AuthDTO;
import com.invertir.ya.model.User;
import com.invertir.ya.repo.IGenericRepo;
import com.invertir.ya.repo.IUserRepo;
import com.invertir.ya.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService
{

    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }

    @Override
    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public User login(AuthDTO dto) {
        return repo.findByUsernameAndPassword(dto.getEmail(), dto.getPassword());
    }

    @Override
    public List<User> saveAll(List<User> t) throws Exception {
        repo.deleteAll();
        return repo.saveAll(t);
    }
}
