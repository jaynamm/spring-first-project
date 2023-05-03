package com.playdata.springfirstproject.domain.web.dto;

import com.playdata.springfirstproject.domain.post.entity.Posts;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Getter
public class PostsListDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime createdDate;

    public PostsListDTO(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.createdDate = posts.getCreatedDate();
    }
}
