package com.invertir.ya.service;

import java.util.List;

public interface ICRUD<T, ID>
{
    T save(T t);
    T update(T t, ID id);
    List<T> readAll();
    T readById(ID id);
    void delete(ID id);
}
