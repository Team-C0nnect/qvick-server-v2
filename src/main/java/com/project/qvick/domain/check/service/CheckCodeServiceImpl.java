package com.project.qvick.domain.check.service;

import com.project.qvick.domain.check.domain.CheckCodeEntity;
import com.project.qvick.domain.check.domain.repository.CheckCodeRepository;
import com.project.qvick.domain.check.presentation.dto.response.CheckCodeResponse;
import com.project.qvick.domain.check.mapper.CheckCodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class CheckCodeServiceImpl implements CheckCodeService {

    private final CheckCodeRepository checkCodeRepository;
    private final CheckCodeMapper checkCodeMapper;

    @Override
    public CheckCodeResponse generate() {
        checkCodeRepository.updateAllInvalidCheckCode(1L);
        CheckCodeEntity checkCodeEntity = checkCodeRepository.save(checkCodeMapper.createCheckCodeEntity(1L));
        return CheckCodeResponse.builder().code(checkCodeEntity.getCode()).build();
    }

}