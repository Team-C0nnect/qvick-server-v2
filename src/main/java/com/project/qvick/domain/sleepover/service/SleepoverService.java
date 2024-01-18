package com.project.qvick.domain.sleepover.service;

import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;

public interface SleepoverService {

    void registerSleepover(Sleepover sleepover);
    void refuseSleepover(Long sleepoverId);
    void acceptSleepover(Long sleepoverId);

}
