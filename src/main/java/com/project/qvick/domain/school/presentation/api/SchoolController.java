package com.project.qvick.domain.school.presentation.api;

import com.project.qvick.domain.school.presentation.dto.School;
import com.project.qvick.domain.school.presentation.dto.request.SchoolRequest;
import com.project.qvick.domain.school.service.SchoolService;
import com.project.qvick.domain.school.service.querydsl.SchoolQueryService;
import com.project.qvick.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
@Tag(name = "학교", description = "학교")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;
    private final SchoolQueryService schoolQueryService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "학교 등록", description = "학교를 등록합니다")
    public void registerSchool(SchoolRequest schoolRequest){
        schoolService.registerSchool(schoolRequest);
    }

    @Operation(summary = "학교 목록", description = "학교 목록을 표시합니다")
    @GetMapping("")
    public ResponseEntity<List<School>> findCheck(PageRequest pageRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(schoolQueryService.schoolList(pageRequest));
    }

}
