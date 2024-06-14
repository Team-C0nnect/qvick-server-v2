package com.project.qvick.domain.outing.client.api;

import com.project.qvick.domain.outing.application.service.OutingService;
import com.project.qvick.domain.outing.client.dto.request.OutingRequest;
import com.project.qvick.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/outing")
@Tag(name = "외출", description = "외출 API")
@SecurityRequirement(name = "BearerAuthentication")
public class OutingController {

    private final OutingService service;

    @PostMapping("")
    @Operation(summary = "외출 신청", description = "외출을 신청합니다")
    public BaseResponse register(@Validated @RequestBody OutingRequest request){
        service.register(request.toOuting());
        return BaseResponse.created("외출 신청 완료");
    }

}
