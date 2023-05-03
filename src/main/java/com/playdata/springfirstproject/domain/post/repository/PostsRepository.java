package com.playdata.springfirstproject.domain.post.repository;

import com.playdata.springfirstproject.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> { // <Entity class, id>

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();
}
