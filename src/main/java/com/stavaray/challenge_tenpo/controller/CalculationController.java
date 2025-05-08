package com.stavaray.challenge_tenpo.controller;

import com.stavaray.challenge_tenpo.dto.CalculateRequest;
import com.stavaray.challenge_tenpo.dto.CalculateResponse;
import com.stavaray.challenge_tenpo.service.CalculationService;
import com.stavaray.challenge_tenpo.util.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.CALCULATE_ROUTE)
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calcService;

    @PostMapping
    public ResponseEntity<CalculateResponse> calculate(
            @Valid @RequestBody CalculateRequest request) {
        return ResponseEntity.ok(calcService.calculate(request));
    }

}
