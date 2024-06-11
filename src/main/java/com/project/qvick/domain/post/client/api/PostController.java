package com.project.qvick.domain.post.client.api;

import com.project.qvick.domain.post.application.query.PostQueryService;
import com.project.qvick.domain.post.application.service.PostService;
import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostDeleteRequest;
import com.project.qvick.domain.post.client.dto.request.PostEditRequest;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;
import com.project.qvick.domain.post.client.dto.request.PostSearchRequest;
import com.project.qvick.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Tag(name = "공지사항", description = "공지사항 API")
public class PostController {

    private final PostService postService;
    private final PostQueryService postQueryService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "공시사항 등록", description = "공지사항을 등록합니다.")
    public void postRegister(@RequestBody PostRegisterRequest request){
        postService.postRegister(request);
    }

    @GetMapping("")
    @Operation(summary = "공지사항 조회", description = "하나의 공지사항을 ID를 기준으로 조회합니다.")
    public Post postFind(@PathVariable Long postId){
        return postService.postFind(postId);
    }

    @GetMapping("/list")
    @Operation(summary = "공지사항 목록", description = "등록된 모든 공지사항 목록을 표시합니다.")
    public ResponseEntity<List<Post>> postList(@ModelAttribute PageRequest pageRequest){
        return ResponseEntity.ok().body(postQueryService.postList(pageRequest));
    }

    @GetMapping("/search")
    @Operation(summary = "공지사항 검색", description = "제목을 기준으로 검색된 공지사항 목록을 표시합니다.")
    public ResponseEntity<List<Post>> postSearch(@ModelAttribute PostSearchRequest postSearchRequest){
        return ResponseEntity.ok().body(postQueryService.postSearch(postSearchRequest));
    }

    @PatchMapping("")
    @Operation(summary = "공지사항 수정", description = "공지사항의 제목과 내용을 수정합니다.")
    public void postEdit(@RequestBody PostEditRequest request){
        postService.postEdit(request);
    }

    @DeleteMapping("")
    @Operation(summary = "공지사항 삭제", description = "공지사항을 삭제합니다.")
    public void postDelete(@RequestBody PostDeleteRequest request){
        postService.postDelete(request);
    }

}
