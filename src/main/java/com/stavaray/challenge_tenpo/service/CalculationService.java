package com.stavaray.challenge_tenpo.service;

import com.stavaray.challenge_tenpo.dto.CalculateRequest;
import com.stavaray.challenge_tenpo.dto.CalculateResponse;

import java.math.BigDecimal;

public interface CalculationService {
    CalculateResponse calculate(CalculateRequest request);
}
