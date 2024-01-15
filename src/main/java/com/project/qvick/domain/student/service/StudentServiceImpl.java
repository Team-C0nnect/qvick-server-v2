package com.project.qvick.domain.student.service;

import com.project.qvick.domain.student.domain.repository.StudentRepository;
import com.project.qvick.domain.student.exception.StudentExistException;
import com.project.qvick.domain.student.exception.StudentNotFoundException;
import com.project.qvick.domain.student.mapper.StudentMapper;
import com.project.qvick.domain.student.presentation.dto.Student;
import com.project.qvick.domain.student.presentation.dto.request.StudentEditRequest;
import com.project.qvick.domain.student.presentation.dto.request.StudentRequest;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final UserSecurity userSecurity;
    private final StudentMapper studentMapper;

    @Override
    public Student findStudent(){
        return studentRepository
                .findById(userSecurity.getUser().getId())
                .map(studentMapper::toStudent)
                .orElseThrow(() -> StudentNotFoundException.EXCEPTION);
    }

    @Override
    public void register(StudentRequest studentRequest){
        if(studentRepository.findById(userSecurity.getUser().getId()).isPresent()){
            throw StudentExistException.EXCEPTION;
        }
        studentRepository.save(studentMapper
                .toCreate(userSecurity.getUser().getId(), studentRequest.getStdId()));
    }

    @Override
    public void studentEdit(StudentEditRequest studentEditRequest) {

        Student student = studentRepository.findById(userSecurity.getUser().getId())
                .map(studentMapper::toStudent).orElseThrow(() -> StudentNotFoundException.EXCEPTION);
        student.setStdId(studentEditRequest.getStdId());
        studentRepository.save(studentMapper.toCreate(userSecurity.getUser().getId(), studentEditRequest.getStdId()));
    }

    @Override
    public void studentDelete(){

        if(studentRepository.findById(userSecurity.getUser().getId()).isEmpty()){
            throw StudentNotFoundException.EXCEPTION;
        }
        studentRepository.deleteById(userSecurity.getUser().getId());

    }

}
