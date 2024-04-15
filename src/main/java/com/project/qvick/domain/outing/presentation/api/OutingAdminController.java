package com.project.qvick.domain.outing.presentation.api;

import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.presentation.dto.request.OutingPageRequest;
import com.project.qvick.domain.outing.presentation.dto.request.OutingSettingRequest;
import com.project.qvick.domain.outing.service.OutingService;
import com.project.qvick.domain.outing.service.querydsl.OutingQueryService;
import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import com.project.qvick.domain.sleepover.presentation.dto.request.SleepoverPageRequest;
import com.project.qvick.domain.sleepover.presentation.dto.request.SleepoverSettingRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/outing-admin")
@Tag(name = "외출 관리자", description = "외출 관리자")
public class OutingAdminController {

    private final OutingService service;
    private final OutingQueryService queryService;

    @Operation(summary = "외출 승인")
    @PutMapping("/accept")
    @ResponseStatus(HttpStatus.OK)
    public void acceptSleepover(@RequestBody OutingSettingRequest request) {
        service.accept(request.getOutingId());
    }

    @Operation(summary = "외출 거절")
    @PutMapping("/refuse")
    @ResponseStatus(HttpStatus.OK)
    public void refuseSleepover(@Validated @RequestBody OutingSettingRequest request) {
        service.accept(request.getOutingId());
    }

    @Operation(summary = "외출 조회", description = "")
    @GetMapping("/findStudents")
    public ResponseEntity<List<Outing>> findStudents(OutingPageRequest request) {
        return ResponseEntity.ok(queryService.findOutStudents(request));
    }

}
