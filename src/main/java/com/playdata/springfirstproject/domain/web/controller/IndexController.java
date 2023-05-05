package com.playdata.springfirstproject.domain.web.controller;

import com.playdata.springfirstproject.domain.post.dto.PostsListResponseDTO;
import com.playdata.springfirstproject.domain.post.service.PostsService;
import com.playdata.springfirstproject.global.security.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        List<PostsListResponseDTO> postsList = postsService.findAllDesc();
        // Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsList);

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/write")
    public String createPosts() {
        return "posts_save";
    }

    @GetMapping("/posts/{id}")
    public String updatePosts(Model model, @PathVariable Long id) {
        model.addAttribute("post", postsService.findById(id));
        return "posts_modify";
    }
}
