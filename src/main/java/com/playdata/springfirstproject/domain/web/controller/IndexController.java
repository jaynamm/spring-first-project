package com.playdata.springfirstproject.domain.web.controller;

import com.playdata.springfirstproject.domain.post.dto.PostsDTO;
import com.playdata.springfirstproject.domain.post.entity.Posts;
import com.playdata.springfirstproject.domain.post.service.PostsService;
import com.playdata.springfirstproject.domain.web.dto.PostsListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        List<PostsListDTO> postsList = postsService.findAllDesc();
        // Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsList);
        return "index";
    }

    @GetMapping("/posts/write")
    public String PostsCreateForm() {
        return "posts_save";
    }

    @GetMapping("/posts/${id}")
    public String PostsById(Model model, @PathVariable Long id) {
        return "posts_update";
    }
}
