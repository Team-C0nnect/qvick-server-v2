package com.project.qvick.domain.user.presentation;

import com.project.qvick.domain.user.dto.request.UserSignUpRequest;
import com.project.qvick.domain.user.service.UserService;
import com.project.qvick.domain.user.service.querydsl.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final UserQueryService queryService;

    @PostMapping("/approve")
    @ResponseStatus(HttpStatus.OK)
    public void userApprove(@Validated @RequestBody UserSignUpRequest request){
        service.acceptSignUp(request);
    }

    @PostMapping("/reject")
    public void userReject(@Validated @RequestBody UserSignUpRequest request){
        service.rejectSignUp(request);
    }

}
