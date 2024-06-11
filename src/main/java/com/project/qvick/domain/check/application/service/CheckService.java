package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.client.dto.request.CodeRequest;

public interface CheckService {

    void attendance(CodeRequest codeRequest);

}