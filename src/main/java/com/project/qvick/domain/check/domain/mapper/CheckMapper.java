package com.project.qvick.domain.check.domain.mapper;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.domain.CheckEntity;
import com.project.qvick.global.annotation.Mapper;

@Mapper
public class CheckMapper {

    public CheckEntity toCreate(Check check) {
        return CheckEntity.builder()
                .name(check.getName())
                .stdId(check.getStdId())
                .isChecked(check.isChecked())
                .checkedDate(check.getCheckedDate())
                .room(check.getRoom())
                .build();
    }

}
