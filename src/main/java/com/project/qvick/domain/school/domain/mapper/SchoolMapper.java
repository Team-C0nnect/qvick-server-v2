package com.project.qvick.domain.school.domain.mapper;

import com.project.qvick.domain.school.domain.SchoolEntity;
import com.project.qvick.domain.school.client.dto.School;
import com.project.qvick.global.annotation.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public class SchoolMapper {

    public School toSchool(SchoolEntity schoolEntity){
        return School
                .builder()
                .schoolName(schoolEntity.getSchoolName())
                .build();
    }

    public SchoolEntity toCreate(String schoolName){
        return SchoolEntity.builder()
                .schoolName(schoolName)
                .build();
    }

}
