package com.project.qvick.domain.school.application.service;

import com.project.qvick.domain.school.domain.repository.jpa.SchoolRepository;
import com.project.qvick.domain.school.exception.SchoolExistException;
import com.project.qvick.domain.school.domain.mapper.SchoolMapper;
import com.project.qvick.domain.school.client.dto.request.SchoolRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public void registerSchool(SchoolRequest schoolRequest){
        if(schoolRepository.findBySchoolName(schoolRequest.getSchoolName()).isPresent()){
            throw SchoolExistException.EXCEPTION;
        }
        schoolRepository.save(schoolMapper.toCreate(schoolRequest.getSchoolName()));
    }

}