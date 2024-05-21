package com.project.qvick.domain.check.client.api;

import com.project.qvick.domain.check.application.query.CheckQueryService;
import com.project.qvick.domain.check.application.service.CheckCodeService;
import com.project.qvick.domain.check.application.service.CheckService;
import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import com.project.qvick.domain.check.client.dto.response.CheckCodeResponse;
import com.project.qvick.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
@Tag(name = "출석 명단", description = "출석 명단")
@SecurityRequirement(name = "BearerAuthentication")
public class CheckController {

    private final CheckService checkService;
    private final CheckQueryService checkQueryService;
    private final CheckCodeService checkCodeService;

    @Operation(summary = "출석 체크", description = "출석 체크")
    @PostMapping("")
    public void attendanceCheck(@RequestBody CodeRequest codeRequest) {
        checkService.attendance(codeRequest);
    }

    @Operation(summary = "출석 명단", description = "출석 명단을 표시합니다")
    @GetMapping("/list")
    public ResponseEntity<List<Check>> findCheck(@ModelAttribute PageRequest pageRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(checkQueryService.findCheck(pageRequest));
    }

    @Operation(summary = "출석 코드 생성", description = "출석 코드 생성합니다")
    @PostMapping("/code")
    public ResponseEntity<CheckCodeResponse> generateCheckCode() throws ExecutionException, InterruptedException {
        CompletableFuture<CheckCodeResponse> codeResponseFuture = checkCodeService.generate();
        CheckCodeResponse codes = codeResponseFuture.get();
        return ResponseEntity.status(HttpStatus.CREATED).body(codes);
    }

    @Operation(summary = "출석 확인", description = "출석 상태를 확인합니다")
    @GetMapping("")
    public ResponseEntity<Check> attendanceCheck(){
        return checkService.attendanceCheck();
    }

}
