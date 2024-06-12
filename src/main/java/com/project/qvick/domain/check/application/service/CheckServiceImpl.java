package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.domain.mapper.CheckMapper;
import com.project.qvick.domain.check.domain.repository.jpa.CheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;
    private final CheckMapper checkMapper;

    @Override
    public void register(Check check) {
        checkRepository.save(checkMapper.toCreate(check));
    }

}
