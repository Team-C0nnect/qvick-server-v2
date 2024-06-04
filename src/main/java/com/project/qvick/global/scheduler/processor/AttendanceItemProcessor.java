package com.project.qvick.global.scheduler.processor;

import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class AttendanceItemProcessor implements ItemProcessor<List<String>, List<String>> {

    private final FirebaseNotificationService firebaseNotificationService;

    @Override
    public List<String> process(final List<String> readNonCheckEamils) throws Exception {
        log.info("....................... AttendanceItemProcessor start");

        List<String> tokens = readNonCheckEamils.stream().filter(email -> firebaseNotificationService.hasKey(email)).map(email -> firebaseNotificationService.getToken(email)).toList();

        log.info("....................... AttendanceItemProcessor end");
        return tokens;
    }

}
