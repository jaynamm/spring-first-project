package com.playdata.springfirstproject.domain.post.controller;

import com.playdata.springfirstproject.domain.post.dto.PostsDTO;
import com.playdata.springfirstproject.domain.post.dto.PostsSaveRequestDTO;
import com.playdata.springfirstproject.domain.post.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class PostsAPIController {
    private final PostsService postsService;

    @PostMapping("posts/write")
    public Long save(@RequestBody PostsSaveRequestDTO requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDTO requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/posts/{id}")
    public PostsDTO findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
