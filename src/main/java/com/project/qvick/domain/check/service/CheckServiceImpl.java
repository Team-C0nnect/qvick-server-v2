package com.project.qvick.domain.check.service;

import com.project.qvick.domain.check.domain.CheckEntity;
import com.project.qvick.domain.check.domain.repository.CheckCodeRepository;
import com.project.qvick.domain.check.domain.repository.CheckRepository;
import com.project.qvick.domain.check.exception.CheckAlreadyExistsException;
import com.project.qvick.domain.check.exception.CheckCodeError;
import com.project.qvick.domain.check.exception.CheckCodeExpirationException;
import com.project.qvick.domain.check.mapper.CheckMapper;
import com.project.qvick.domain.check.presentation.dto.request.CodeRequest;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;
    private final CheckCodeRepository checkCodeRepository;
    private final CheckMapper checkMapper;
    private final UserSecurity userSecurity;

    private static final Executor executor = Executors.newFixedThreadPool(10);

    @Override
    public void attendance(CodeRequest codeRequest) {

        CheckEntity checkEntity = checkMapper.createCheckEntity(userSecurity.getUser().getId(), LocalDate.now());

        if (checkRepository.findByUserIdAndCheckedDate(checkEntity.getUserId(), checkEntity.getCheckedDate()).isPresent()) {
            throw CheckAlreadyExistsException.EXCEPTION;
        }
        if (checkCodeRepository.existsByCodeAndValid(codeRequest.getCode(), true)) {
            checkRepository.save(checkEntity);
        } else {
            throw CheckCodeExpirationException.EXCEPTION;
        }
        throw CheckCodeError.EXCEPTION;

    }

    @Override
    public ResponseEntity<Void> attendanceCheck() {

        if (checkRepository.findByUserIdAndCheckedDate(userSecurity.getUser().getId(),LocalDate.now()).isPresent()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
