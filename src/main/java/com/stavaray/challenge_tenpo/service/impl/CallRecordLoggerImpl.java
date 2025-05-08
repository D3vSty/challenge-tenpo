package com.stavaray.challenge_tenpo.service.impl;

import com.stavaray.challenge_tenpo.entity.CallRecord;
import com.stavaray.challenge_tenpo.repository.CallRecordRepository;
import com.stavaray.challenge_tenpo.service.CallRecordLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CallRecordLoggerImpl implements CallRecordLogger {

    private final CallRecordRepository recordRepo;

    @Async
    public void log(int num1, int num2, double percentage, double total) {
        recordRepo.save(CallRecord.builder()
                .num1(num1)
                .num2(num2)
                .percentage(percentage)
                .total(total)
                .timestamp(Instant.now()).build());
    }
}
