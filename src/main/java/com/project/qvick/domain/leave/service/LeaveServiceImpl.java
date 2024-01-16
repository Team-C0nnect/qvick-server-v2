package com.project.qvick.domain.leave.service;

import com.project.qvick.domain.leave.domain.repository.LeaveRepository;
import com.project.qvick.domain.leave.exception.LeaveAlreadyDeletedException;
import com.project.qvick.domain.leave.exception.LeaveAlreadySelectedException;
import com.project.qvick.domain.leave.mapper.LeaveMapper;
import com.project.qvick.domain.leave.presentation.dto.Leave;
import com.project.qvick.domain.leave.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;
    private final LeaveMapper leaveMapper;

    @Override
    public void registerLeaveWeek(Leave leave) {
        if (leaveRepository.findByLeaveDate(leave.getLeaveDate()).isPresent()) {
            throw LeaveAlreadySelectedException.EXCEPTION;
        }
        leaveRepository.save(leaveMapper.toCreate(leave));
    }

    @Override
    public void removeLeaveWeek(Long leaveId) {
        if (leaveRepository.findById(leaveId).isEmpty()) {
            throw LeaveAlreadyDeletedException.EXCEPTION;
        }
        leaveRepository.deleteById(leaveId);
    }
}
