package com.beyond.basic.b2_board.post.controller;

import com.beyond.basic.b2_board.author.dto.CommonDto;
import com.beyond.basic.b2_board.post.dto.PostCreateDto;
import com.beyond.basic.b2_board.post.dto.PostDetailDto;
import com.beyond.basic.b2_board.post.dto.PostListDto;
import com.beyond.basic.b2_board.post.dto.PostSearchDto;
import com.beyond.basic.b2_board.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final com.beyond.basic.b2_board.post.service.PostService postService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PostCreateDto postCreateDto){
        postService.save(postCreateDto);
        return new ResponseEntity<>(new CommonDto("ok",HttpStatus.CREATED.value(), "게시글 작성 완료"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    //페이징 처리를 위한 데이터 요청 형식 : 8080/post/list?paging0&size=20&sort=title,asc
    public ResponseEntity<?> postList(@PageableDefault(size=10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, PostSearchDto dto){
        Page<PostListDto> postListDtos = postService.findAll(pageable, dto);
        return new ResponseEntity<>(new CommonDto(postListDtos, HttpStatus.OK.value(), "모든 게시글을 조회합니다."), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        PostDetailDto postDetailDto = postService.findById(id);
        return new ResponseEntity<>(new CommonDto(postDetailDto, HttpStatus.OK.value(), "post id found"),HttpStatus.OK);
    }
}
