package com.playdata.springfirstproject.domain.post.entity;

import com.playdata.springfirstproject.global.domain.AuditingEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends AuditingEntity {
    @Id // 테이블의 PK 를 의미한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id; // Long => bigint type

    @Column(length = 500, nullable = false) // 기본으로 255 자로 되어있다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
