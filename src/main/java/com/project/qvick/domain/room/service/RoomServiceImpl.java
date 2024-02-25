package com.project.qvick.domain.room.service;

import com.project.qvick.domain.room.domain.repository.RoomRepository;
import com.project.qvick.domain.room.exception.RoomNotFoundException;
import com.project.qvick.domain.room.mapper.RoomMapper;
import com.project.qvick.domain.room.presentation.dto.Room;
import com.project.qvick.domain.room.presentation.dto.request.RoomRequest;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final UserSecurity userSecurity;
    private final RoomMapper roomMapper;

    @Override
    public void roomRegister(RoomRequest request){
        roomRepository.save(roomMapper.toCreate(
                userSecurity.getUser().getId(),
                request.getRoomId()));
    }

    @Override
    public Room findRoom(){
        return roomRepository
                .findByUserId(userSecurity.getUser().getId())
                .map(roomMapper::toRoom)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }

    @Override
    public void roomEdit(RoomRequest request){
        Room room = roomRepository.findByUserId(userSecurity.getUser().getId())
                .map(roomMapper::toRoom).orElseThrow(()-> RoomNotFoundException.EXCEPTION);
        room.setRoomId(request.getRoomId());
        roomRepository.save(roomMapper.toCreate(room.getUserId(), room.getRoomId()));
    }

    @Override
    @Transactional
    public void roomDelete(RoomRequest request){
        if(roomRepository.findByRoomId(request.getRoomId()).isEmpty()){
            throw RoomNotFoundException.EXCEPTION;
        }
        roomRepository.deleteByRoomId(request.getRoomId());
    }

}
