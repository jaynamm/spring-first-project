package com.playdata.springfirstproject.domain.post.repository;

import com.playdata.springfirstproject.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> { // <Entity class, id>
}
