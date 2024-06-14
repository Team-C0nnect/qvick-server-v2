package com.project.qvick.domain.school.client.api;

import com.project.qvick.domain.school.client.dto.School;
import com.project.qvick.domain.school.client.dto.request.SchoolRequest;
import com.project.qvick.domain.school.application.service.SchoolService;
import com.project.qvick.domain.school.application.query.SchoolQueryService;
import com.project.qvick.global.common.dto.request.PageRequest;
import com.project.qvick.global.common.response.BaseResponse;
import com.project.qvick.global.common.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
@Tag(name = "학교", description = "학교 API")
public class SchoolController {

    private final SchoolService schoolService;
    private final SchoolQueryService schoolQueryService;

    @PostMapping("")
    @Operation(summary = "학교 등록", description = "학교를 등록합니다")
    public BaseResponse registerSchool(@RequestBody SchoolRequest schoolRequest){
        schoolService.registerSchool(schoolRequest);
        return BaseResponse.created("학교가 등록되었습니다.");
    }

    @GetMapping("")
    @Operation(summary = "학교 목록", description = "학교 목록을 표시합니다")
    public BaseResponseData<List<School>> findCheck(@ModelAttribute PageRequest pageRequest) {
        return BaseResponseData.ok(
                "학교 목록을 성공적으로 불러왔습니다.",
                schoolQueryService.schoolList(pageRequest));
    }

}
