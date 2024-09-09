package com.backend.prueba.service;

import com.backend.prueba.client.ExchangeRatesClient;
import com.backend.prueba.entity.CurrencyExchange;
import com.backend.prueba.repository.CurrencyExchangeRepository;
import com.backend.prueba.request.CurrencyChangeRequest;
import com.backend.prueba.response.ExchangeRateResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Omar Corahua
 * @FileName: CurrencyChangeService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Service
public class CurrencyChangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;
    @Autowired
    private ExchangeRatesClient exchangeRatesClient;

    public void insertData() {

        CurrencyExchange row1 = new CurrencyExchange();
        row1.setMonto(BigDecimal.valueOf(3));
        row1.setMontoConTipoCambio(BigDecimal.valueOf(9));
        row1.setTipoCambio(BigDecimal.valueOf(3));
        row1.setMonedaDestino("zzz");
        row1.setMonedaOrigen("yyy");
        currencyExchangeRepository.save(row1);

    }

    public CurrencyExchange aplyCurrencyChange(CurrencyChangeRequest request) {
        CurrencyExchange currencyChangeResponse = new CurrencyExchange();

        ExchangeRateResponse response = exchangeRatesClient.getLatestExchangeRates(request.getMonedaOrigen());
        Double rate = response.getRates().get(request.getMonedaDestino());

        BigDecimal montoConTipoCambio = request.getMonto().multiply(BigDecimal.valueOf(rate));

        currencyChangeResponse.setMonedaDestino(request.getMonedaDestino());
        currencyChangeResponse.setMonedaOrigen(request.getMonedaOrigen());
        currencyChangeResponse.setMonto(request.getMonto());
        currencyChangeResponse.setMontoConTipoCambio(montoConTipoCambio);
        currencyChangeResponse.setTipoCambio(BigDecimal.valueOf(rate));
        return currencyChangeResponse;
    }

    public void  insertOneCurrencyValue(CurrencyExchange request){
        List<CurrencyExchange> currencyExchange = new ArrayList<>();
        currencyExchange.add(request);
        currencyExchangeRepository.saveAll(currencyExchange);
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        ExchangeRateResponse response = exchangeRatesClient.getLatestExchangeRates(fromCurrency);
        Double rate = response.getRates().get(toCurrency);
        if (rate == null) {
            throw new IllegalArgumentException("Currency conversion rate not found");
        }
        return amount * rate;
    }

    public List<CurrencyExchange> getList() {

        return currencyExchangeRepository.findAll();
    }

}
