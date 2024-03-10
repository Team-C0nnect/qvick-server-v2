package com.project.qvick.domain.student.mapper;

import com.project.qvick.domain.student.domain.StudentEntity;
import com.project.qvick.domain.student.presentation.dto.Student;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final UserSecurity userSecurity;
    private final UserMapper mapper;

    public Student toStudent(StudentEntity entity){
        return Student.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .build();
    }

    public StudentEntity toCreate(String id){
        return StudentEntity.builder()
                .id(id)
                .userId(mapper.toCreateEntity(userSecurity.getUser()))
                .build();
    }

}
