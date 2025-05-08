package com.stavaray.challenge_tenpo.service.impl;

import com.stavaray.challenge_tenpo.dto.CalculateRequest;
import com.stavaray.challenge_tenpo.dto.CalculateResponse;
import com.stavaray.challenge_tenpo.entity.CallRecord;
import com.stavaray.challenge_tenpo.repository.CallRecordRepository;
import com.stavaray.challenge_tenpo.service.CalculationService;
import com.stavaray.challenge_tenpo.service.CallRecordLogger;
import com.stavaray.challenge_tenpo.service.PercentageService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CalculationServiceImpl implements CalculationService {

    private final PercentageService percentageService;
    private final CallRecordLogger logger;

    @Override
    public CalculateResponse calculate(CalculateRequest req) {
        int sum = req.num1() + req.num2();
        double pct = percentageService.fetchPercentage();
        double total = sum * (1 + pct / 100);

        logger.log(req.num1(), req.num2(), pct, total);

        return new CalculateResponse(sum, pct, total);
    }
}
