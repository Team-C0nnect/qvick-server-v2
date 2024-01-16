package com.project.qvick.domain.wifi.service;

import com.project.qvick.domain.wifi.presentation.dto.request.WifiRequest;
import org.springframework.http.ResponseEntity;

public interface WifiService {
    void wifiRegister(WifiRequest wifiRequest);

    ResponseEntity<Void> wifiCheck(WifiRequest wifiRequest);
}
