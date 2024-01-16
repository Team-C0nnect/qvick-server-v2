package com.project.qvick.domain.wifi.exception;

import com.project.qvick.domain.wifi.exception.error.WifiError;
import com.project.qvick.global.exception.BusinessException;

public class WifiExistException extends BusinessException {

    public static final WifiExistException EXCEPTION = new WifiExistException();

    private WifiExistException() {
        super(WifiError.WIFI_CONFLICT);
    }

}
