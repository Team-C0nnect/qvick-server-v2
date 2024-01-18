package com.project.qvick.domain.outing.presentation;

import com.project.qvick.domain.outing.presentation.dto.request.OutingRequest;
import com.project.qvick.domain.outing.service.OutingService;
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
@RequestMapping("/outing")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuthentication")
@Tag(name = "외출", description = "외출")
public class OutingController {

    private final OutingService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody OutingRequest request){
        service.register(request.toOuting());
    }

}
