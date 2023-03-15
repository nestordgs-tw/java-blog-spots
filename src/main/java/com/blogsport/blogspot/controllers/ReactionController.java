package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.entity.Reaction;
import com.blogsport.blogspot.generic.crud.controller.GenericController;
import com.blogsport.blogspot.generic.crud.service.IGenericService;
import com.blogsport.blogspot.service.IReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reaction")
public class ReactionController extends GenericController<Reaction, Long> {

    @Autowired
    private IReactionService iReactionService;

    @Override
    public IGenericService<Reaction, Long> getService() {
        return iReactionService;
    }
}
