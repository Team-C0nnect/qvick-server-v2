package com.project.qvick.domain.user.presentation.api;

import com.project.qvick.domain.user.presentation.dto.request.RoomRequest;
import com.project.qvick.domain.user.presentation.dto.request.StdIdEditRequest;
import com.project.qvick.domain.user.service.UserService;
import com.project.qvick.domain.user.service.querydsl.UserQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저", description = "유저")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 학번 수정", description = "회원 학번을 수정합니다")
    @PatchMapping("/stdId")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@Validated @RequestBody StdIdEditRequest request){
        userService.editUserStdId(request);
    }

    @Operation(summary = "회원 호실 수정", description = "회원 호실을 수정합니다")
    @PatchMapping("/room")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@Validated @RequestBody RoomRequest request){
        userService.editRoom(request);
    }

    @Operation(summary = "회원탈퇴", description = "회원 탈퇴를 진행합니다.")
    @DeleteMapping("")
    public void deleteUser(){
        userService.deleteUser();
    }

}
