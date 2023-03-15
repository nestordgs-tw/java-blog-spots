package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReactionRepository extends JpaRepository<Reaction, Long> {

}
