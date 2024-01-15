package com.project.qvick.domain.wifi.exception;

import com.project.qvick.domain.wifi.exception.error.WifiError;
import com.project.qvick.global.exception.BusinessException;

public class WifiNotFoundException extends BusinessException {

    public static final WifiNotFoundException EXCEPTION = new WifiNotFoundException();

    private WifiNotFoundException() {
        super(WifiError.WIFI_NOT_FOUND);
    }

}

