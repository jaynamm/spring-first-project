package com.playdata.springfirstproject.domain.post.dto;

import com.playdata.springfirstproject.domain.post.entity.Posts;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class PostsListResponseDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime createdDate;

    public PostsListResponseDTO(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.createdDate = posts.getCreatedDate();
    }
}
