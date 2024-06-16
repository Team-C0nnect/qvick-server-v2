package com.project.qvick.domain.user.client.api;

import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import com.project.qvick.domain.user.application.service.UserService;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.PasswordEditRequest;
import com.project.qvick.domain.user.client.dto.request.StdIdEditRequest;
import com.project.qvick.global.common.dto.response.BaseResponse;
import com.project.qvick.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/attendance")
    @Operation(summary = "출석체크", description = "출석 체크를 진행합니다.")
    public BaseResponse check(@RequestBody CodeRequest request){
        userService.check(request);
        return BaseResponse.ok("출석이 완료되었습니다.");
    }

    @GetMapping("/status")
    @Operation(summary = "상태 확인", description = "출석 상태를 확인합니다.")
    public BaseResponseData<HttpStatus> isChecked() {
        return userService.isChecked() ?
                BaseResponseData.of(HttpStatus.OK,"출석",HttpStatus.OK) :
                BaseResponseData.of(HttpStatus.BAD_REQUEST,"미출석",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    @Operation(summary = "유저 조회", description = "현재 로그인한 유저 정보를 조회합니다")
    public BaseResponseData<User> findUser(){
        return BaseResponseData.ok(
                "유저 정보를 성공적으로 조회하였습니다.",
                userService.findUser());
    }

    @PatchMapping("/stdId")
    @Operation(summary = "회원 학번 수정", description = "회원 학번을 수정합니다")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse editUser(@Validated @RequestBody StdIdEditRequest request){
        userService.editUserStdId(request);
        return BaseResponse.ok("학번을 성공적으로 수정하였습니다.");
    }

    @PatchMapping("/password")
    @Operation(summary = "비밀번호 변경", description = "현재 로그인한 유저의 비밀번호를 변경합니다")
    public BaseResponse editPassword(PasswordEditRequest request){
        userService.editPassword(request);
        return BaseResponse.ok("비밀번호가 성공적으로 변경되었습니다.");
    }

    @DeleteMapping("")
    @Operation(summary = "회원탈퇴", description = "회원 탈퇴를 진행합니다")
    public BaseResponse deleteUser(){
        userService.deleteUser();
        return BaseResponse.ok("회원탈퇴가 완료되었습니다.");
    }

}
