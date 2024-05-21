package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import org.springframework.http.ResponseEntity;

public interface CheckService {

    void attendance(CodeRequest codeRequest);

    ResponseEntity<Check> attendanceCheck();

}