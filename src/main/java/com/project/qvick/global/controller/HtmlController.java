package com.project.qvick.global.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "약관", description = "약관")
@RequestMapping("/terms")
public class HtmlController {

    @Operation(summary = " 개인정보처리약관", description = "개인정보처리약관을 불러옵니다")
    @GetMapping("/privacy-policy")
    public String privacyPolicy(){
        return "PrivacyPolicy";
    }

}
