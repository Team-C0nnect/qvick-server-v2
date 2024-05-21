package com.project.qvick.domain.outing.client.api;

import com.project.qvick.domain.outing.client.dto.request.OutingRequest;
import com.project.qvick.domain.outing.application.service.OutingService;
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
@RequestMapping("/outing")
@Tag(name = "외출", description = "외출 API")
@SecurityRequirement(name = "BearerAuthentication")
public class OutingController {

    private final OutingService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody OutingRequest request){
        service.register(request.toOuting());
    }

}
