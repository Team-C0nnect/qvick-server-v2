package com.project.qvick.domain.student.service;

import com.project.qvick.domain.student.presentation.dto.request.StudentRequest;

public interface StudentService {
    void findStudent(StudentRequest studentRequest);
}
