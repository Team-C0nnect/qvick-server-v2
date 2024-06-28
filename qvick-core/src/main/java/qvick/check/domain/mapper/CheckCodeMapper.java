package qvick.check.domain.mapper;

import qvick.annotation.Mapper;
import qvick.check.domain.CheckCodeEntity;

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