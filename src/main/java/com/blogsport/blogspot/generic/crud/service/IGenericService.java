package com.blogsport.blogspot.generic.crud.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T, I extends Serializable> {

    List<T> findAll();

    T save(T entity);

    void delete(I id);
}
