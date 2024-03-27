package com.project.qvick.domain.user.presentation;

import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.presentation.dto.request.UserSignUpRequest;
import com.project.qvick.domain.user.presentation.dto.response.UserPageResponse;
import com.project.qvick.domain.user.service.UserService;
import com.project.qvick.domain.user.service.querydsl.UserQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저", description = "유저")
public class UserController {

    private final UserService service;
    private final UserQueryService queryService;

    @Operation(summary = "유저 승인", description = "유저를 승인합니다")
    @PutMapping("/approve")
    @ResponseStatus(HttpStatus.OK)
    public void userApprove(@Validated @RequestBody UserSignUpRequest request){
        service.acceptSignUp(request);
    }

    @Operation(summary = "유저 거부", description = "유저를 거부합니다")
    @PutMapping("/reject")
    public void userReject(@Validated @RequestBody UserSignUpRequest request){
        service.rejectSignUp(request);
    }

    @Operation(summary = "유저 조회", description = "승인 대기 유저를 조회합니다.")
    @GetMapping("")
    public ResponseEntity<List<UserPageResponse>> findWaitingUsers(UserApprovalPageRequest request){
        return ResponseEntity.ok(queryService.findWaitingUsers(request));
    }

}
