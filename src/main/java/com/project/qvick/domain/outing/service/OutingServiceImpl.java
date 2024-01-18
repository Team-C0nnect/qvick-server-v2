package com.project.qvick.domain.outing.service;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.domain.outing.domain.repository.OutingRepository;
import com.project.qvick.domain.outing.exception.OutingAlreadyWaitingException;
import com.project.qvick.domain.outing.exception.OutingNotFoundException;
import com.project.qvick.domain.outing.mapper.OutingMapper;
import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.service.querydsl.OutingQueryService;
import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class OutingServiceImpl implements OutingService{

    private final UserSecurity userSecurity;
    private final OutingMapper mapper;
    private final OutingRepository repository;

    @Override
    public void register(Outing outing) {
        if(repository.findById(userSecurity.getUser().getId()).get().getApproval().equals(SleepoverStatus.SLEEPOVER_WAITING)){
            throw OutingAlreadyWaitingException.EXCEPTION;
        }
        repository.save(mapper.toCreate(outing));
    }

    @Override
    public void refuse(Long outingId) {
        Outing outing = repository.findById(outingId).map(mapper::toOuting).orElseThrow(()-> OutingNotFoundException.EXCEPTION);
        outing.setApproval(OutingStatus.SLEEPOVER_REJECTED);
        repository.save(mapper.toUpdate(outing));
    }

    @Override
    public void accept(Long outingId) {
        Outing outing = repository.findById(outingId).map(mapper::toOuting).orElseThrow(()-> OutingNotFoundException.EXCEPTION);
        outing.setApproval(OutingStatus.SLEEPOVER_ACCEPTED);
        repository.save(mapper.toUpdate(outing));
    }

}
