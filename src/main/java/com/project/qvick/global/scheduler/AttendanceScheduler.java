package com.project.qvick.global.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Slf4j
@Configuration
@EnableScheduling
@EnableBatchProcessing
@RequiredArgsConstructor
public class AttendanceScheduler {

    private final JobLauncher jobLauncher;
    private final Job checkAttendanceJob;

    //    @Scheduled(cron = "0 */5 * * * *", zone = "Asia/Seoul")
    @Scheduled(cron = "0 0 22 * * *", zone = "Asia/Seoul") // 매일 10시에 알림 보내기
    public void attendance() throws Exception {
        final JobParameters parameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        log.info(".......................... Attendance Batch Start : {} ", LocalDateTime.now());
        jobLauncher.run(checkAttendanceJob, parameters);
    }

}
