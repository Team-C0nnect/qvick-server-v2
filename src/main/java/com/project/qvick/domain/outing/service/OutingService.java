package com.project.qvick.domain.outing.service;

import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.presentation.dto.request.OutingSettingRequest;

public interface OutingService {

    void register(Outing outing);
    void refuse(Long outingId);
    void accept(Long outingId);

}
