package com.project.qvick.domain.outing.application.service;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.domain.outing.domain.repository.jpa.OutingRepository;
import com.project.qvick.domain.outing.exception.OutingAlreadyWaitingException;
import com.project.qvick.domain.outing.exception.OutingNotFoundException;
import com.project.qvick.domain.outing.domain.mapper.OutingMapper;
import com.project.qvick.domain.outing.client.dto.Outing;
import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutingServiceImpl implements OutingService{

    private final UserSecurity userSecurity;
    private final OutingMapper mapper;
    private final OutingRepository repository;

    @Override
    public void register(Outing outing) {
        if(repository.findById(userSecurity.getUser().getId()).get().getApproval().equals(SleepoverStatus.SLEEPOVER_NOT_ACCEPTED)){
            throw OutingAlreadyWaitingException.EXCEPTION;
        }
        repository.save(mapper.toCreate(outing));
    }

    @Override
    public void refuse(Long outingId) {
        Outing outing = repository.findById(outingId).map(mapper::toOuting).orElseThrow(()-> OutingNotFoundException.EXCEPTION);
        outing.setApproval(OutingStatus.OUTING_NOT_ACCEPTED);
        repository.save(mapper.toUpdate(outing));
    }

    @Override
    public void accept(Long outingId) {
        Outing outing = repository.findById(outingId).map(mapper::toOuting).orElseThrow(()-> OutingNotFoundException.EXCEPTION);
        outing.setApproval(OutingStatus.OUTING_ACCEPTED);
        repository.save(mapper.toUpdate(outing));
    }

}
