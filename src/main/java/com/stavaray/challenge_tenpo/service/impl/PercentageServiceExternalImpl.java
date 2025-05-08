package com.stavaray.challenge_tenpo.service.impl;

import com.stavaray.challenge_tenpo.exception.ExternalServiceException;
import com.stavaray.challenge_tenpo.service.PercentageService;
import com.stavaray.challenge_tenpo.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PercentageServiceExternalImpl implements PercentageService {

    private final WebClient client;

    @Override
    @Cacheable("percentage")
    public double fetchPercentage() {
        try {
            Mono<Double> mono = client.get()
                    .uri(Constants.PERCENTAGE_ROUTE)
                    .retrieve()
                    .bodyToMono(Double.class);
            return mono
                    .doOnError(err -> {
                        throw new ExternalServiceException("Error fetching percentage", err);
                    })
                    .blockOptional()
                    .orElseThrow(() -> new ExternalServiceException("Percentage API returned no data"));
        } catch (ExternalServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ExternalServiceException("Error fetching percentage", ex);
        }
    }
}
