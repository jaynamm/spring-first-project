package com.playdata.springfirstproject.domain.post.controller;

import com.playdata.springfirstproject.domain.post.dto.PostsDTO;
import com.playdata.springfirstproject.domain.post.entity.Posts;
import com.playdata.springfirstproject.domain.post.repository.PostsRepository;
import com.playdata.springfirstproject.domain.post.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/posts/write")
    public Long savePosts(@RequestBody PostsDTO postsDTO) {
        return postsService.save(postsDTO);
    }

//    @PostMapping("/posts/update")
//    public Long updatePosts(@RequestBody PostsDTO postsDTO) {
//        return postsService.update(postsDTO);
//    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
