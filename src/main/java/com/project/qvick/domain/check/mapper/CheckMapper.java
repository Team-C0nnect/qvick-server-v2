package com.project.qvick.domain.check.mapper;

import com.project.qvick.domain.check.domain.CheckEntity;
import com.project.qvick.domain.check.presentation.dto.Check;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CheckMapper {

    public CheckEntity createCheckEntity(final Long userId, final LocalDate date) {
        return CheckEntity.builder()
                .userId(userId)
                .checkedDate(date)
                .build();
    }

    public Check toCheck(CheckEntity entity){
        return Check.builder()
                .checkedDate(entity.getCheckedDate())
                .build();
    }

}