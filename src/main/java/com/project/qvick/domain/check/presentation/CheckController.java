package com.project.qvick.domain.check.presentation;

import com.project.qvick.domain.check.presentation.dto.Check;
import com.project.qvick.domain.check.presentation.dto.request.CodeRequest;
import com.project.qvick.domain.check.presentation.dto.response.CheckCodeResponse;
import com.project.qvick.domain.check.service.CheckCodeService;
import com.project.qvick.domain.check.service.CheckService;
import com.project.qvick.domain.check.service.querydsl.CheckQueryService;
import com.project.qvick.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "출석 명단", description = "출석 명단")
@SecurityRequirement(name = "BearerAuthentication")
@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class CheckController {

    private final CheckService checkService;
    private final CheckQueryService checkQueryService;
    private final CheckCodeService checkCodeService;

    @Operation(summary = "출석 체크", description = "출석 체크")
    @PostMapping("")
    public void attendanceCheck(CodeRequest codeRequest) {
        checkService.attendance(codeRequest);
    }

    @Operation(summary = "출석 명단", description = "출석 명단을 표시합니다")
    @GetMapping("/list")
    public ResponseEntity<List<Check>> findCheck(PageRequest pageRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(checkQueryService.findCheck(pageRequest));
    }

    @Operation(summary = "출석 코드 생성", description = "출석 코드 생성합니다")
    @PostMapping("/code")
    public ResponseEntity<CheckCodeResponse> generateCheckCode() {
        return ResponseEntity.status(HttpStatus.CREATED).body(checkCodeService.generate());
    }

    @Operation(summary = "출석 확인", description = "출석 상태를 확인합니다")
    @GetMapping("")
    public ResponseEntity<Void> attendanceCheck(){
        return checkService.attendanceCheck();
    }

}
