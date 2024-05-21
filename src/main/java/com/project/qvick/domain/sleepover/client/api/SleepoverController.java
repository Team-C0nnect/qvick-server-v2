package com.project.qvick.domain.sleepover.client.api;

import com.project.qvick.domain.sleepover.client.dto.request.SleepoverRequest;
import com.project.qvick.domain.sleepover.application.service.SleepoverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sleepover")
@Tag(name = "외박", description = "외박")
@SecurityRequirement(name = "BearerAuthentication")
public class SleepoverController {

    private final SleepoverService sleepoverService;

    @Operation(summary = "외박 신청")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerSleepover(@Validated @RequestBody SleepoverRequest request){
        sleepoverService.registerSleepover(request.toSleepover());
    }

}

