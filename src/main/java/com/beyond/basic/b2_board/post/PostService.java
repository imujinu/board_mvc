package com.beyond.basic.b2_board.post;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.author.repository.AuthorRepository;
import com.beyond.basic.b2_board.author.service.AuthorService;
import com.beyond.basic.b2_board.post.domain.Post;
import com.beyond.basic.b2_board.post.dto.PostCreateDto;
import com.beyond.basic.b2_board.post.dto.PostDetailDto;
import com.beyond.basic.b2_board.post.dto.PostListDto;
import com.beyond.basic.b2_board.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    @Autowired // 생성자가 한개일때는 안붙여도된다.
    public PostService(PostRepository postRepository, AuthorService authorService, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    public void save(PostCreateDto postCreateDto){
        // authorId가 실제 있는지 없는지 검증.
//        postRepository.find(postCreateDto.getAuthorId())
        Author author = authorRepository.findById(postCreateDto.getAuthorId()).orElseThrow(()->new EntityNotFoundException("존재하지 않는 게시글입니다."));
        postRepository.save(postCreateDto.toEntity(author));
    }

    public PostDetailDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new EntityNotFoundException("존재하지 않는 게시글입니다.")
        );
        // 엔티티간의 관계성 설정을 하지 않았을 때
//        Author author = authorRepository.findById(post.getAuthorId()).orElseThrow(()->new EntityNotFoundException("존재하지 않는 회원입니다."));
//        authorService.getOrElseThrow(post.getAuthorId())
//        return PostDetailDto.fromEntity(post,post.getAuthor());

        //엔티티간의 관계성 설정을 통해 Author 객체를 쉽게 조회하는 경우
        return PostDetailDto.fromEntity(post);
    }

    public List<PostListDto> findAll(){
              return  postRepository.findAll().stream().map((a)->new PostListDto().fromEntity(a)).collect(Collectors.toList());
    }
}
