package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Reaction;
import com.blogsport.blogspot.generic.crud.service.GenericServiceImpl;
import com.blogsport.blogspot.repository.IReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImpl extends GenericServiceImpl<Reaction, Long> implements IReactionService {

    @Autowired
    private IReactionRepository iReactionRepository;

    @Override
    protected JpaRepository<Reaction, Long> getRepository() {
        return iReactionRepository;
    }
}
