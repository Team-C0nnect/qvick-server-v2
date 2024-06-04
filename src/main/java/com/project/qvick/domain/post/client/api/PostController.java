package com.project.qvick.domain.post.client.api;

import com.project.qvick.domain.post.application.service.PostService;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Tag(name = "공지사항", description = "공지사항 API")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name = "공지사항 등록", description = "공지사항을 등록합니다.")
    public void postRegister(@RequestBody PostRegisterRequest request){
        postService.postRegister(request);
    }

}
