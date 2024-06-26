package com.project.qvick.domain.user.client.api;

import com.project.qvick.domain.check.application.query.CheckQueryService;
import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.user.application.query.UserQueryService;
import com.project.qvick.domain.user.application.service.UserService;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.AdminPasswordEditRequest;
import com.project.qvick.domain.user.client.dto.request.AdminSetStatusRequest;
import com.project.qvick.domain.user.client.dto.request.RoomEditRequest;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.project.qvick.global.common.dto.response.BaseResponse;
import com.project.qvick.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-admin")
@Tag(name = "유저 관리자", description = "유저 관리자 API")
public class UserAdminController {

    private final UserQueryService userQueryService;
    private final CheckQueryService checkQueryService;
    private final UserService userService;

    @GetMapping("/find-all")
    @Operation(summary = "전체 유저 조회", description = "전체 유저를 조회합니다")
    public BaseResponseData<List<User>> userList(@ModelAttribute PageRequest pageRequest){
        return BaseResponseData.ok(
                "전체 유저 목록을 성공적으로 불러왔습니다.",
                userQueryService.userList(pageRequest));
    }

    @GetMapping("/student-all")
    @Operation(summary = "전체 학생 조회", description = "전체 학생을 조회합니다")
    public BaseResponseData<List<User>>studentList(@ModelAttribute PageRequest pageRequest){
        return BaseResponseData.ok(
                "전체 학생 목록을 성공적으로 불러왔습니다.",
                userQueryService.studentList(pageRequest));
    }

    @GetMapping("/search")
    @Operation(summary = "유저 검색", description = "특정 유저를 이름을 기준으로 검색합니다")
    public BaseResponseData<List<User>>userSearch(@ModelAttribute UserSearchRequest searchRequest){
        return BaseResponseData.ok(
                "검색 결과를 성공적으로 불러왔습니다.",
                userQueryService.userSearch(searchRequest));
    }

    @GetMapping("/check")
    @Operation(summary = "출석 명단 조회", description = "출석 확인자 명단을 조회합니다.")
    public BaseResponseData<List<Check>>checkList(@ModelAttribute PageRequest pageRequest){
        return BaseResponseData.ok(
                "출석 명단을 성공적으로 불러왔습니다.",
                checkQueryService.findAllCheckUsers(pageRequest));
    }

    @GetMapping("/non-check")
    @Operation(summary = "미출석 명단 조회", description = "미출석자 명단을 조회합니다.")
    public BaseResponseData<List<User>>nonCheckList(@ModelAttribute PageRequest pageRequest){
        return BaseResponseData.ok(
                "미출석 명단을 성공적으로 불러왔습니다.",
                userQueryService.nonCheckUsers(pageRequest));
    }

    @PatchMapping("")
    @Operation(summary = "비밀번호 변경", description = "해당 이메일을 가진 유저의 비밀번호를 변경합니다")
    public BaseResponse editPassword(AdminPasswordEditRequest request){
        userService.adminEditPassword(request);
        return BaseResponse.ok("비밀번호가 변경되었습니다.");
    }

    @PatchMapping("/room")
    @Operation(summary = "회원 호실 수정", description = "회원 호실을 수정합니다")
    public BaseResponse editUser(@Validated @RequestBody RoomEditRequest request){
        userService.editRoom(request);
        return BaseResponse.ok("호실을 성공적으로 수정하였습니다.");
    }

    @DeleteMapping("")
    @Operation(summary = "회원 삭제", description = "해당 이메일을 가진 유저를 삭제합니다.")
    public BaseResponse deleteUser(@RequestParam String email){
        userService.adminDeleteUser(email);
        return BaseResponse.ok("회원이 삭제되었습니다.");
    }

    @PatchMapping("/fix-status")
    public BaseResponse fixStatus(@RequestBody AdminSetStatusRequest setStatusRequest){
        userService.fixStatus(setStatusRequest);
        return BaseResponse.ok("회원 출석 상태 수정이 완료되었습니다.");
    }

}
