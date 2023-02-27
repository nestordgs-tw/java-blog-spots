package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.entity.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostRepositoryImpl implements IPostRepository {

    @Override
    public List<Post> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        List<Post> myList = new ArrayList<>();


        myList.add(new Post("Title one", "Testing description 1", "Testing Content"));
        myList.add(new Post("Title two", "Testing description 2", "Testing Content"));
        myList.add(new Post("Title three", "Testing description 3", "Testing Waka"));

        return myList;
    }

    @Override
    public <S extends Post> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Post> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Post> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }




    @Override
    public Iterable<Post> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Post entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Post findById(long id) {
        return null;
    }
}
