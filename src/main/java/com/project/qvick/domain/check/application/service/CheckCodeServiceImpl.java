package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.client.dto.response.CheckCodeResponse;
import com.project.qvick.domain.check.domain.CheckCodeEntity;
import com.project.qvick.domain.check.domain.mapper.CheckCodeMapper;
import com.project.qvick.domain.check.domain.repository.jpa.CheckCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class CheckCodeServiceImpl implements CheckCodeService {

    private final CheckCodeRepository checkCodeRepository;
    private final CheckCodeMapper checkCodeMapper;

    @Override
    @Async
    public CompletableFuture<CheckCodeResponse> generate() {
        checkCodeRepository.updateAllInvalidCheckCode(1L);
        CheckCodeEntity checkCodeEntity = checkCodeRepository.save(checkCodeMapper.createCheckCodeEntity(1L));
        return CompletableFuture.completedFuture(CheckCodeResponse.builder().code(checkCodeEntity.getCode()).build());
    }

}