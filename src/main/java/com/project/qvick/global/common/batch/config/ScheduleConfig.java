package com.project.qvick.global.common.batch.config;

import com.project.qvick.domain.check.application.query.CheckQueryService;
import com.project.qvick.global.common.batch.processor.AttendanceItemProcessor;
import com.project.qvick.global.common.batch.reader.AttendanceItemReader;
import com.project.qvick.global.common.batch.writer.AttendanceItemWriter;
import com.project.qvick.global.infra.firebase.service.FirebaseNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class ScheduleConfig {

    private static final int CHUNK_SIZE = 1;
    private final CheckQueryService checkQueryService;
    private final FirebaseNotificationService firebaseNotificationService;

    @Bean
    public Job checkAttendanceJob(final Step checkAttendanceStep, final JobRepository jobRepository) {
        return new JobBuilder("checkAttendanceJob", jobRepository)
                .preventRestart()
                .flow(checkAttendanceStep)
                .end()
                .build();
    }

    @Bean
    public Step checkAttendanceStep(final JobRepository jobRepository, final PlatformTransactionManager transactionManager) {
        return new StepBuilder("checkAttendanceStep", jobRepository)
                .<List<String>, List<String>>chunk(CHUNK_SIZE, transactionManager)
                .startLimit(1)
                .reader(attendanceReader())
                .processor(attendanceProcessor())
                .writer(attendanceWriter())
                .build();
    }

    @Bean
    public ItemReader<List<String>> attendanceReader() {
        return new AttendanceItemReader(checkQueryService);
    }

    @Bean
    public ItemProcessor<List<String>, List<String>> attendanceProcessor() {
        return new AttendanceItemProcessor(firebaseNotificationService);
    }

    @Bean
    public ItemWriter<List<String>> attendanceWriter() {
        return new AttendanceItemWriter(firebaseNotificationService);
    }

}
