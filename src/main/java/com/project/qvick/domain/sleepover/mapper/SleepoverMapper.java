package com.project.qvick.domain.sleepover.mapper;

import com.project.qvick.domain.sleepover.domain.SleepoverEntity;
import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SleepoverMapper {
    public Sleepover toSleepover(SleepoverEntity entity){
        return Sleepover.builder()
                .id(entity.getId())
                .reason(entity.getReason())
                .approval(entity.getApproval())
                .startDateTime(entity.getStartDateTime())
                .endDateTime(entity.getEndDateTime())
                .createdDate(LocalDateTime.from(entity.getCreatedDateTime()))
                .modifiedDate(LocalDateTime.from(entity.getModifiedDateTime()))
                .build();
    }

    public SleepoverEntity toUpdate(Sleepover sleepover){
        return SleepoverEntity.builder()
                .id(sleepover.getId())
                .userId(sleepover.getUserId())
                .startDateTime(sleepover.getStartDateTime())
                .endDateTime(sleepover.getEndDateTime())
                .reason(sleepover.getReason())
                .approval(sleepover.getApproval())
                .createdDateTime(sleepover.getCreatedDate())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }
    public SleepoverEntity toCreate(Sleepover sleepover){
        return SleepoverEntity.builder()
                .userId(sleepover.getUserId())
                .startDateTime(sleepover.getStartDateTime())
                .endDateTime(sleepover.getEndDateTime())
                .reason(sleepover.getReason())
                .approval(SleepoverStatus.SLEEPOVER_WAITING)
                .createdDateTime(sleepover.getCreatedDate())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }

}
