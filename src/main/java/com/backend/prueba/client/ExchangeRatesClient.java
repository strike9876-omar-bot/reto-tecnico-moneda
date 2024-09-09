package com.backend.prueba.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.prueba.response.ExchangeRateResponse;

@FeignClient(name = "exchangeRatesClient", url = "https://open.er-api.com/v6")
public interface ExchangeRatesClient {

    @GetMapping("/latest/{currency}")
    ExchangeRateResponse getLatestExchangeRates(@PathVariable("currency") String currency);
}
