package com.project.qvick.domain.sleepover.application.service;

import com.project.qvick.domain.sleepover.client.dto.Sleepover;

public interface SleepoverService {

    void registerSleepover(Sleepover sleepover);
    void refuseSleepover(Long sleepoverId);
    void acceptSleepover(Long sleepoverId);

}
