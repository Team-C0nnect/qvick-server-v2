package com.project.qvick.domain.check.domain.mapper;

import com.project.qvick.domain.check.domain.CheckCodeEntity;
import com.project.qvick.global.annotation.Mapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Mapper
public class CheckCodeMapper {

    public CheckCodeEntity createCheckCodeEntity(final Long userId) {
        return CheckCodeEntity.builder()
                .userId(userId)
                .code(UUID.randomUUID().toString().replace("-", ""))
                .valid(true)
                .build();
    }

}