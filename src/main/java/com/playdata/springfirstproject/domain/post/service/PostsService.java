package com.playdata.springfirstproject.domain.post.service;

import com.playdata.springfirstproject.domain.post.dto.PostsDTO;
import com.playdata.springfirstproject.domain.post.dto.PostsListResponseDTO;
import com.playdata.springfirstproject.domain.post.dto.PostsSaveRequestDTO;
import com.playdata.springfirstproject.domain.post.entity.Posts;
import com.playdata.springfirstproject.domain.post.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDTO requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDTO requestDto) {
        Posts posts = postsRepository.findById(id)   //command option v -> 참조 변수 생성
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsDTO findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + id));
        return new PostsDTO(posts);
    }

    @Transactional
    public List<PostsListResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + id));
        postsRepository.delete(posts);
    }
}
