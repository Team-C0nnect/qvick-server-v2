package com.project.qvick.domain.school.presentation;

import com.project.qvick.domain.school.presentation.dto.request.SchoolRequest;
import com.project.qvick.domain.school.service.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@Tag(name = "학교", description = "학교")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "학교 등록", description = "학교를 등록합니다")
    public void registerSchool(SchoolRequest schoolRequest){
        schoolService.registerSchool(schoolRequest);
    }

}
