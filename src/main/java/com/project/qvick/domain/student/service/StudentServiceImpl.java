package com.project.qvick.domain.student.service;

import com.project.qvick.domain.student.domain.repository.StudentRepository;
import com.project.qvick.domain.student.presentation.dto.request.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public void findStudent(StudentRequest studentRequest){
        studentRepository.findByStdId(studentRequest.getStdId());
    }

}
