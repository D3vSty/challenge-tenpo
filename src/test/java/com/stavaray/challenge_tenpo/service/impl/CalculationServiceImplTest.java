package com.stavaray.challenge_tenpo.service.impl;

import com.stavaray.challenge_tenpo.dto.CalculateRequest;
import com.stavaray.challenge_tenpo.dto.CalculateResponse;
import com.stavaray.challenge_tenpo.service.CallRecordLogger;
import com.stavaray.challenge_tenpo.service.PercentageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculationServiceImplTest {

    @Mock
    PercentageService percentageService;

    @Mock
    CallRecordLogger logger;

    @InjectMocks
    CalculationServiceImpl service;

    @Test
    void calculateAppliesPercentageCorrectlyAndLogsAsync() {
        when(percentageService.fetchPercentage()).thenReturn(20.0);
        CalculateResponse resp = service.calculate(new CalculateRequest(5, 10));
        assertEquals(15, resp.sum());
        assertEquals(20.0, resp.percentage());
        assertEquals(18.0, resp.total());

        verify(logger, times(1))
                .log(5, 10, 20.0, 18.0);
    }
}