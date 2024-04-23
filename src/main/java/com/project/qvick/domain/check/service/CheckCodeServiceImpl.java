package com.project.qvick.domain.check.service;

import com.project.qvick.domain.check.domain.CheckCodeEntity;
import com.project.qvick.domain.check.domain.repository.CheckCodeRepository;
import com.project.qvick.domain.check.mapper.CheckCodeMapper;
import com.project.qvick.domain.check.presentation.dto.response.CheckCodeResponse;
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
    private final UserSecurity userSecurity;

    Long id = userSecurity.getUser().getId();

    @Override
    @Async
    public CompletableFuture<CheckCodeResponse> generate() {
        checkCodeRepository.updateAllInvalidCheckCode(id);
        CheckCodeEntity checkCodeEntity = checkCodeRepository.save(checkCodeMapper.createCheckCodeEntity(id));
        return CompletableFuture.completedFuture(CheckCodeResponse.builder().code(checkCodeEntity.getCode()).build());
    }

}