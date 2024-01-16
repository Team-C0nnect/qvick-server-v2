package com.project.qvick.domain.wifi.service;

import com.project.qvick.domain.wifi.domain.repository.WifiRepository;
import com.project.qvick.domain.wifi.exception.WifiExistException;
import com.project.qvick.domain.wifi.exception.WifiNotFoundException;
import com.project.qvick.domain.wifi.mapper.WifiMapper;
import com.project.qvick.domain.wifi.presentation.dto.request.WifiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WifiServiceImpl implements WifiService{

    private final WifiRepository wifiRepository;
    private final WifiMapper wifiMapper;

    @Override
    public void wifiRegister(WifiRequest wifiRequest){
        if(wifiRepository.findBySsid(wifiRequest.getSsid()).isPresent()){
            throw WifiExistException.EXCEPTION;
        }
        wifiRepository.save(wifiMapper.createEntity(wifiRequest));
    }

    @Override
    public ResponseEntity<Void> wifiCheck(WifiRequest wifiRequest){
        if(wifiRepository.findBySsid(wifiRequest.getSsid()).isEmpty()){
            throw WifiNotFoundException.EXCEPTION;
        }
        return ResponseEntity.ok().build();
    }

}
