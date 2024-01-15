package com.project.qvick.domain.student.service;

import com.project.qvick.domain.student.presentation.dto.Student;
import com.project.qvick.domain.student.presentation.dto.request.StudentEditRequest;
import com.project.qvick.domain.student.presentation.dto.request.StudentRequest;

public interface StudentService {

    Student findStudent();

    void register(StudentRequest studentRequest);

    void studentEdit(StudentEditRequest studentEditRequest);

    void studentDelete();
}
