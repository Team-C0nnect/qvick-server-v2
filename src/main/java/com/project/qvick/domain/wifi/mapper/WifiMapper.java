package com.project.qvick.domain.wifi.mapper;

import com.project.qvick.domain.wifi.domain.WifiEntity;
import com.project.qvick.domain.wifi.presentation.dto.request.WifiRequest;
import org.springframework.stereotype.Component;

@Component
public class WifiMapper {

    public WifiEntity createEntity(WifiRequest wifiRequest) {
        return WifiEntity.builder()
                .ssid(wifiRequest.getSsid())
                .build();
    }

}
