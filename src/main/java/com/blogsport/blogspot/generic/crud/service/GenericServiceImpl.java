package com.blogsport.blogspot.generic.crud.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class GenericServiceImpl<T, I extends Serializable> implements IGenericService<T, I> {

    protected abstract JpaRepository<T, I> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(I id) {
        getRepository().deleteById(id);
    }

    public void delete(T entity) {
        getRepository().delete(entity);
    }
}
