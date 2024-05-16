package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.domain.CheckEntity;
import com.project.qvick.domain.check.domain.repository.jpa.CheckCodeRepository;
import com.project.qvick.domain.check.domain.repository.jpa.CheckRepository;
import com.project.qvick.domain.check.exception.CheckAlreadyExistsException;
import com.project.qvick.domain.check.exception.CheckCodeError;
import com.project.qvick.domain.check.exception.CheckCodeExpirationException;
import com.project.qvick.domain.check.mapper.CheckMapper;
import com.project.qvick.domain.check.presentation.dto.Check;
import com.project.qvick.domain.check.presentation.dto.request.CodeRequest;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;
    private final CheckCodeRepository checkCodeRepository;
    private final CheckMapper checkMapper;
    private final UserSecurity userSecurity;

    @Override
    public void attendance(CodeRequest codeRequest) {
        CheckEntity checkEntity = checkMapper.createCheckEntity(
                userSecurity.getUser().getId(),
                userSecurity.getUser().getStdId(),
                userSecurity.getUser().getName(),
                userSecurity.getUser().getEmail(),
                userSecurity.getUser().getRoom(),
                LocalDate.now());
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
        throw CheckCodeError.EXCEPTION;
    }

    @Override
    public ResponseEntity<Check> attendanceCheck() {
        Check check = checkRepository.findByUserId(
                userSecurity.getUser().getId())
                .map(checkMapper::toCheck)
                .orElseThrow(()->CheckCodeError.EXCEPTION);
        if (checkRepository.findByUserIdAndCheckedDate(
                userSecurity.getUser().getId(),
                LocalDate.now()).isPresent()){
            return ResponseEntity.ok().body(check);
        }
        return ResponseEntity.notFound().build();
    }

}
