package com.project.qvick.domain.room.service;

import com.project.qvick.domain.room.domain.repository.RoomRepository;
import com.project.qvick.domain.room.exception.RoomExistException;
import com.project.qvick.domain.room.mapper.RoomMapper;
import com.project.qvick.domain.room.presentation.dto.request.RoomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public void roomRegister(RoomRequest request){
        if(roomRepository.findByRoomId(request.getRoomId()).isPresent()){
            throw RoomExistException.EXCEPTION;
        }
        roomRepository.save(roomMapper.toCreate(request.getRoomId()));
    }

}
