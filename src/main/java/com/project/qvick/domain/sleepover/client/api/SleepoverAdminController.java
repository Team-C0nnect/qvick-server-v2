package com.project.qvick.domain.sleepover.client.api;

import com.project.qvick.domain.sleepover.client.dto.Sleepover;
import com.project.qvick.domain.sleepover.client.dto.request.SleepoverPageRequest;
import com.project.qvick.domain.sleepover.client.dto.request.SleepoverSettingRequest;
import com.project.qvick.domain.sleepover.application.service.SleepoverService;
import com.project.qvick.domain.sleepover.application.query.SleepoverQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sleepover-admin")
@Tag(name = "외박 관리자", description = "외박 관리자 API")
public class SleepoverAdminController {

    private final SleepoverService sleepoverService;
    private final SleepoverQueryService querydslService;

    @GetMapping("/findStudents")
    @Operation(summary = "외박 조회", description = "외박 명단을 조회합니다")
    public ResponseEntity<List<Sleepover>> findStudents(@ModelAttribute SleepoverPageRequest request) {
        return ResponseEntity.ok(querydslService.findSleepoverStudents(request));
    }

    @PutMapping("/accept")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "외박 승인", description = "외박을 승인합니다")
    public void acceptSleepover(@RequestBody SleepoverSettingRequest request) {
        sleepoverService.acceptSleepover(request.getSleepoverId());
    }

    @PutMapping("/refuse")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "외박 거절", description = "외박을 거절합니다")
    public void refuseSleepover(@Validated @RequestBody SleepoverSettingRequest request) {
        sleepoverService.refuseSleepover(request.getSleepoverId());
    }

}
