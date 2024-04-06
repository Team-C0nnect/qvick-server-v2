package com.project.qvick.domain.school.mapper;

import com.project.qvick.domain.school.domain.SchoolEntity;
import com.project.qvick.domain.school.presentation.dto.School;
import org.springframework.stereotype.Component;

@Component
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
