package com.beyond.basic.b2_board.post.controller;

import com.beyond.basic.b2_board.author.dto.CommonDto;
import com.beyond.basic.b2_board.post.PostService;
import com.beyond.basic.b2_board.post.dto.PostCreateDto;
import com.beyond.basic.b2_board.post.dto.PostDetailDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PostCreateDto postCreateDto){
        postService.save(postCreateDto);
        return new ResponseEntity<>(new CommonDto("ok",HttpStatus.CREATED.value(), "게시글 작성 완료"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> postList(){
        return new ResponseEntity<>(new CommonDto(postService.findAll(), HttpStatus.OK.value(), "모든 게시글을 조회합니다."), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        PostDetailDto postDetailDto = postService.findById(id);
        return new ResponseEntity<>(new CommonDto(postDetailDto, HttpStatus.OK.value(), "post id found"),HttpStatus.OK);
    }
}
