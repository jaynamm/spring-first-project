package com.playdata.springfirstproject.domain.post.service;

import com.playdata.springfirstproject.domain.post.dto.PostsDTO;
import com.playdata.springfirstproject.domain.post.entity.Posts;
import com.playdata.springfirstproject.domain.post.repository.PostsRepository;
import com.playdata.springfirstproject.domain.web.dto.PostsListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;


    /**
     * 게시글 저장
     * @param postsDTO
     * @return 입력받은 데이터를 엔티티로 변환해서 DB 에 저장
     */

    public Long save(PostsDTO postsDTO) {
        return postsRepository.save(postsDTO.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsListDTO> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        postsRepository.deleteById(id);
    }
}
