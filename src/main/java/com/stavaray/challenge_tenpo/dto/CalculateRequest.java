package com.stavaray.challenge_tenpo.dto;

import jakarta.validation.constraints.Min;

public record CalculateRequest(
        @Min(0) int num1,
        @Min(0) int num2
) {}
