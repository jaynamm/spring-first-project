package com.playdata.springfirstproject.domain.post.repository;

import com.playdata.springfirstproject.domain.post.entity.Posts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void auditingEntity() {
        // given
        String title = "title";
        String content = "content";
        String author = "author";
        LocalDateTime now = LocalDateTime.now();

        // when
        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author(author)
                .build());

        Posts posts = postsRepository.findAll().get(0);

        // then
        Assertions.assertThat(posts.getCreatedDate()).isAfter(now);
        Assertions.assertThat(posts.getModifiedDate()).isAfter(now);

    }

}