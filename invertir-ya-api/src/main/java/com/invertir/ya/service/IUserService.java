package com.invertir.ya.service;

import com.invertir.ya.dto.AuthDTO;
import com.invertir.ya.model.User;

import java.util.List;

public interface IUserService extends ICRUD<User, Integer>
{
    User findByUsername(String username);
    User login(AuthDTO dto);
    List<User> saveAll(List<User> t) throws Exception;
}
