package com.stavaray.challenge_tenpo.dto;

import com.stavaray.challenge_tenpo.entity.CallRecord;

import java.time.Instant;

public record CallRecordDto(
        Long id,
        int num1,
        int num2,
        double percentage,
        double total,
        Instant timestamp
) {
    public static CallRecordDto fromEntity(CallRecord e) {
        return new CallRecordDto(
                e.getId(), e.getNum1(), e.getNum2(),
                e.getPercentage(), e.getTotal(), e.getTimestamp()
        );
    }
}
