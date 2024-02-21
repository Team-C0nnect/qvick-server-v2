package com.project.qvick.domain.room.presentation;

import com.project.qvick.domain.room.presentation.dto.request.RoomRequest;
import com.project.qvick.domain.room.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
@Tag(name = "호실", description = "호실")
public class RoomController {

    private final RoomService roomService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "호실 등록", description = "호실을 등록합니다")
    public void roomRegister(RoomRequest request){
        roomService.roomRegister(request);
    }

    @PutMapping("")
    @Operation(summary = "호실 수정", description = "호실을 수정합니다")
    public void roomEdit(RoomRequest request){
        roomService.roomEdit(request);
    }

    @DeleteMapping("")
    @Operation(summary = "호실 삭제", description = "호실을 삭제합니다.")
    public void roomDelete(RoomRequest request){
        roomService.roomDelete(request);
    }

}
