package com.project.qvick.domain.outing.application.service;

import com.project.qvick.domain.outing.presentation.dto.Outing;

public interface OutingService {

    void register(Outing outing);
    void refuse(Long outingId);
    void accept(Long outingId);

}
