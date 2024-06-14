package com.project.qvick.domain.outing.client.api;

import com.project.qvick.domain.outing.application.query.OutingQueryService;
import com.project.qvick.domain.outing.application.service.OutingService;
import com.project.qvick.domain.outing.client.dto.Outing;
import com.project.qvick.domain.outing.client.dto.request.OutingPageRequest;
import com.project.qvick.domain.outing.client.dto.request.OutingSettingRequest;
import com.project.qvick.global.common.response.BaseResponse;
import com.project.qvick.global.common.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/outing-admin")
@Tag(name = "외출 관리자", description = "외출 관리자 API")
public class OutingAdminController {

    private final OutingService service;
    private final OutingQueryService queryService;

    @GetMapping("/findStudents")
    @Operation(summary = "외출 명단 조회", description = "외출 명단을 조회합니다")
    public BaseResponseData<List<Outing>> findStudents(@ModelAttribute OutingPageRequest request) {
        return BaseResponseData.ok(
                "외출 명단을 성공적으로 불러왔습니다.",
                queryService.findOutStudents(request));
    }

    @PutMapping("/accept")
    @Operation(summary = "외출 승인", description = "외출을 승인합니다")
    public BaseResponse acceptSleepover(@RequestBody OutingSettingRequest request) {
        service.accept(request.getOutingId());
        return BaseResponse.ok("외출이 승인되었습니다.");
    }

    @PutMapping("/refuse")
    @Operation(summary = "외출 거절", description = "외출을 거절합니다")
    public BaseResponse refuseSleepover(@Validated @RequestBody OutingSettingRequest request) {
        service.accept(request.getOutingId());
        return BaseResponse.ok("외출이 거절되었습니다.");
    }

}
