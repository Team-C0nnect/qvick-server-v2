package com.project.qvick.domain.sleepover.application.service;

import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import com.project.qvick.domain.sleepover.domain.repository.jpa.SleepoverRepository;
import com.project.qvick.domain.sleepover.exception.SleepoverAlreadyExistsException;
import com.project.qvick.domain.sleepover.exception.SleepoverNotFoundException;
import com.project.qvick.domain.sleepover.mapper.SleepoverMapper;
import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SleepoverServiceImpl implements SleepoverService {

    private final SleepoverRepository sleepoverRepository;
    private final UserSecurity userSecurity;
    private final SleepoverMapper sleepoverMapper;

    @Override
    public void registerSleepover(Sleepover sleepover) {
        if (sleepoverRepository.findByUserId(userSecurity.getUser().getId()).isPresent()) {
            throw SleepoverAlreadyExistsException.EXCEPTION;
        }
        sleepoverRepository.save(sleepoverMapper.toCreate(sleepover));
    }

    @Override
    public void refuseSleepover(Long sleepoverId) {

        Sleepover sleepover = sleepoverRepository.findById(sleepoverId).map(sleepoverMapper::toSleepover).orElseThrow(() -> SleepoverNotFoundException.EXCEPTION);
        sleepover.setApproval(SleepoverStatus.SLEEPOVER_NOT_ACCEPTED);
        sleepoverRepository.save(sleepoverMapper.toUpdate(sleepover));

    }

    @Override
    public void acceptSleepover(Long sleepoverId){
        Sleepover sleepover = sleepoverRepository.findById(sleepoverId).map(sleepoverMapper::toSleepover).orElseThrow(() -> SleepoverNotFoundException.EXCEPTION);
        sleepover.setApproval(SleepoverStatus.SLEEPOVER_ACCEPTED);
        sleepoverRepository.save(sleepoverMapper.toUpdate(sleepover));
    }

}
