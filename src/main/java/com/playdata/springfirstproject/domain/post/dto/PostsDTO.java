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

    @Builder
    public PostsDTO(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
