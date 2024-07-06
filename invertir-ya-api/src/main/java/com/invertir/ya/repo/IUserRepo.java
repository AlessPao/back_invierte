package com.invertir.ya.repo;

import com.invertir.ya.model.User;

public interface IUserRepo extends IGenericRepo<User, Integer>
{
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
