package com.playdata.springfirstproject.domain.post.dto;

import com.playdata.springfirstproject.domain.post.entity.Posts;
import lombok.*;

@Getter
@NoArgsConstructor
public class PostsDTO {
    private Long id;
    private String title;
    private String author;
    private String content;

    public PostsDTO(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.content = posts.getContent();
    }
}
