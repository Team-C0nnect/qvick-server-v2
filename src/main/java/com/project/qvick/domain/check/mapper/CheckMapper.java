package com.project.qvick.domain.check.mapper;

import com.project.qvick.domain.check.domain.CheckEntity;
import com.project.qvick.domain.check.presentation.dto.Check;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CheckMapper {

    public CheckEntity createCheckEntity(final Long userId,
                                         String stdId,
                                         String name,
                                         String email,
                                         String room,
                                         final LocalDate date) {
        return CheckEntity.builder()
                .userId(userId)
                .stdId(stdId)
                .name(name)
                .email(email)
                .room(room)
                .checkedDate(date)
                .build();
    }

    public Check toCheck(CheckEntity entity){
        return Check.builder()
                .checkedDate(entity.getCheckedDate())
                .build();
    }

}