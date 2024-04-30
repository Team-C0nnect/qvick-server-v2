package com.project.qvick.domain.check.service;

import com.project.qvick.domain.check.domain.CheckCodeEntity;
import com.project.qvick.domain.check.domain.repository.CheckCodeRepository;
import com.project.qvick.domain.check.mapper.CheckCodeMapper;
import com.project.qvick.domain.check.presentation.dto.response.CheckCodeResponse;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.global.common.repository.UserSecurity;
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
    private final UserRepository userRepository;

    @Override
    @Async
    public CompletableFuture<CheckCodeResponse> generate() {
        CheckCodeEntity checkCodeEntity = checkCodeRepository.save(checkCodeMapper.createCheckCodeEntity(1L));
        return CompletableFuture.completedFuture(CheckCodeResponse.builder().code(checkCodeEntity.getCode()).build());
    }

}