package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import com.project.qvick.domain.check.domain.CheckEntity;
import com.project.qvick.domain.check.domain.mapper.CheckMapper;
import com.project.qvick.domain.check.domain.repository.jpa.CheckCodeRepository;
import com.project.qvick.domain.check.domain.repository.jpa.CheckRepository;
import com.project.qvick.domain.check.exception.CheckAlreadyExistsException;
import com.project.qvick.domain.check.exception.CheckCodeExpirationException;
import com.project.qvick.domain.user.application.util.UserUtil;
import com.project.qvick.domain.user.client.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;
    private final CheckCodeRepository checkCodeRepository;
    private final CheckMapper checkMapper;
    private final UserUtil userUtil;

    @Override
    public void attendance(CodeRequest codeRequest) {
        User user = userUtil.findUser();
        CheckEntity checkEntity = checkMapper.createCheckEntity(user, LocalDateTime.now());
        if (checkRepository.findByUserIdAndCheckedDate(
                checkEntity.getUserId(),
                checkEntity.getCheckedDate())
                .isPresent()) {
            throw CheckAlreadyExistsException.EXCEPTION;
        }
        if (checkCodeRepository.existsByCodeAndValid(codeRequest.getCode(), true)) {
            checkRepository.save(checkEntity);
        } else {
            throw CheckCodeExpirationException.EXCEPTION;
        }
    }

}
