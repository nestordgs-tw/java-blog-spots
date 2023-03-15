package com.blogsport.blogspot.generic.crud.controller;

import com.blogsport.blogspot.generic.crud.service.IGenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class GenericController<T, I extends Serializable> {

    public abstract IGenericService<T, I> getService();

    @GetMapping
    public List<T> findAll(){
        return getService().findAll();
    }

    @PostMapping
    public ResponseEntity<T> save(@Validated @RequestBody T entity){
        return ResponseEntity.ok(getService().save(entity));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable I id){
        getService().delete(id);
    }
}
