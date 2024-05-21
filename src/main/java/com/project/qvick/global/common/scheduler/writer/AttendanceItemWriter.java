package com.project.qvick.global.common.scheduler.writer;

import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class AttendanceItemWriter implements ItemWriter<List<String>> {

    private final FirebaseNotificationService firebaseNotificationService;

    @Override
    public void write(Chunk<? extends List<String>> chunk) throws Exception {
        log.info("....................... AttendanceItemWriter start");
        for (List<String> tokenList : chunk.getItems()) {
            firebaseNotificationService.sendNonCheckNotification(tokenList);
        }
        log.info("....................... AttendanceItemWriter end");
    }

}
