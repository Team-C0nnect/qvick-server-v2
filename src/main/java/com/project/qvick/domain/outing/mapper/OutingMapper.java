package com.project.qvick.domain.outing.mapper;

import com.project.qvick.domain.outing.domain.OutingEntity;
import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.domain.outing.presentation.dto.Outing;
import org.springframework.stereotype.Component;

@Component
public class OutingMapper {

    public Outing toOuting(OutingEntity entity){
        return Outing.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .startDateTime(entity.getStartDateTime())
                .endDateTime(entity.getEndDateTime())
                .reason(entity.getReason())
                .approval(entity.getApproval())
                .build();
    }

    public OutingEntity toCreate(Outing outing){
        return OutingEntity.builder()
                .userId(outing.getUserId())
                .startDateTime(outing.getStartDateTime())
                .endDateTime(outing.getEndDateTime())
                .reason(outing.getReason())
                .approval(OutingStatus.SLEEPOVER_WAITING)
                .build();
    }

    public OutingEntity toUpdate(Outing outing){
        return OutingEntity.builder()
                .id(outing.getId())
                .userId(outing.getUserId())
                .startDateTime(outing.getStartDateTime())
                .endDateTime(outing.getEndDateTime())
                .reason(outing.getReason())
                .approval(outing.getApproval())
                .build();
    }

}
