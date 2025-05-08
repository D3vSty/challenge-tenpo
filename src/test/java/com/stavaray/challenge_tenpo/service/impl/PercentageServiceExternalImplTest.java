package com.stavaray.challenge_tenpo.service.impl;

import com.stavaray.challenge_tenpo.exception.ExternalServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PercentageServiceExternalImplTest {

    @Mock
    WebClient webClient;
    @Mock
    RequestHeadersUriSpec<?> uriSpec;
    @Mock
    RequestHeadersSpec<?> headersSpec;
    @Mock
    ResponseSpec responseSpec;

    @InjectMocks
    private PercentageServiceExternalImpl service;

    @BeforeEach
    void setUp() {

        doReturn(uriSpec)
                .when(webClient).get();

        doReturn(headersSpec)
                .when(uriSpec).uri("/api/v1/percentage");

        when(headersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void fetchPercentageSuccessReturnsValue() {
        when(responseSpec.bodyToMono(Double.class))
                .thenReturn(Mono.just(42.0));

        double pct = service.fetchPercentage();

        assertEquals(42.0, pct);

        verify(webClient).get();
        verify(uriSpec).uri("/api/v1/percentage");
        verify(headersSpec).retrieve();
        verify(responseSpec).bodyToMono(Double.class);
    }

    @Test
    void fetchPercentageEmptyMonoThrowsNoData() {
        when(responseSpec.bodyToMono(Double.class))
                .thenReturn(Mono.empty());

        ExternalServiceException ex = assertThrows(
                ExternalServiceException.class,
                () -> service.fetchPercentage()
        );
        assertEquals("Percentage API returned no data", ex.getMessage());
    }

    @Test
    void fetchPercentageErrorMonoThrowsWrappedError() {
        when(responseSpec.bodyToMono(Double.class))
                .thenReturn(Mono.error(new RuntimeException("HTTP 500")));

        ExternalServiceException ex = assertThrows(
                ExternalServiceException.class,
                () -> service.fetchPercentage()
        );
        assertTrue(ex.getMessage().contains("Error fetching percentage"));
        assertNotNull(ex.getCause());
    }

}
