package com.project.qvick.domain.student.mapper;

import com.project.qvick.domain.student.domain.StudentEntity;
import com.project.qvick.domain.student.presentation.dto.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toStudent(StudentEntity entity){
        return Student.builder()
                .id(entity.getId())
                .stdId(entity.getStdId())
                .build();
    }

    public StudentEntity toCreate(Long id, String stdId){
        return StudentEntity.builder()
                .id(id)
                .stdId(stdId)
                .build();
    }

}
