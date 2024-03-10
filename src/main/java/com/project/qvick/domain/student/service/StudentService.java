package com.project.qvick.domain.student.service;

import com.project.qvick.domain.student.presentation.dto.Student;
import com.project.qvick.domain.student.presentation.dto.request.StudentEditRequest;

public interface StudentService {

    Student findStudent();

    void register(String id);

    void studentEdit(StudentEditRequest studentEditRequest);

    void studentDelete();
}
