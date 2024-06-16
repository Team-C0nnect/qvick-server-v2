package com.project.qvick.domain.check.client.api;

import com.project.qvick.domain.check.application.service.CheckCodeService;
import com.project.qvick.domain.check.client.dto.response.CheckCodeResponse;
import com.project.qvick.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
@Tag(name = "출석", description = "출석 API")
@SecurityRequirement(name = "BearerAuthentication")
public class CheckController {

    private final CheckCodeService checkCodeService;

    @PostMapping("/code")
    @Operation(summary = "출석 코드 생성", description = "출석 코드 생성합니다")
    public BaseResponseData<CheckCodeResponse> generateCheckCode() throws ExecutionException, InterruptedException {
        CompletableFuture<CheckCodeResponse> codeResponseFuture = checkCodeService.generate();
        CheckCodeResponse codes = codeResponseFuture.get();
        return BaseResponseData.created(
                "출석 코드 생성 성공",
                codes);
    }

}
