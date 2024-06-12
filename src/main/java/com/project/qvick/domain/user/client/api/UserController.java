package com.project.qvick.domain.user.client.api;

import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import com.project.qvick.domain.user.application.service.UserService;
import com.project.qvick.domain.user.application.util.UserUtil;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.RoomRequest;
import com.project.qvick.domain.user.client.dto.request.StdIdEditRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저", description = "유저 API")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    @Operation(summary = "유저 조회", description = "현재 로그인한 유저 정보를 조회합니다")
    public User findUser(){
        return userService.findUser();
    }

    @PatchMapping("/stdId")
    @Operation(summary = "회원 학번 수정", description = "회원 학번을 수정합니다")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@Validated @RequestBody StdIdEditRequest request){
        userService.editUserStdId(request);
    }

    @PatchMapping("/room")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "회원 호실 수정", description = "회원 호실을 수정합니다")
    public void editUser(@Validated @RequestBody RoomRequest request){
        userService.editRoom(request);
    }

    @DeleteMapping("")
    @Operation(summary = "회원탈퇴", description = "회원 탈퇴를 진행합니다")
    public void deleteUser(){
        userService.deleteUser();
    }

    @PostMapping("/attendance")
    @Operation(summary = "출석체크", description = "출석 체크를 진행합니다.")
    public void check(@RequestBody CodeRequest request){
        userService.check(request);
    }

    @GetMapping("/status")
    @Operation(summary = "상태 확인", description = "출석 상태를 확인합니다.")
    public ResponseEntity<HttpStatus> isChecked() {
        return ResponseEntity.status(userService.isChecked() ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(userService.isChecked() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
