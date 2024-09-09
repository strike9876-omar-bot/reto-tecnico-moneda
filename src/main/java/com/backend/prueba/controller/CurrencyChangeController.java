package com.backend.prueba.controller;

import com.backend.prueba.entity.CurrencyExchange;
import com.backend.prueba.request.CurrencyChangeRequest;
import com.backend.prueba.service.CurrencyChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Omar Corahua
 * @FileName: CurrencyChangeController.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@RestController
@RequestMapping("/exchangeHouse")
public class CurrencyChangeController {

    @Autowired
    private CurrencyChangeService currencyChangeService;

    @PostMapping(value = "/applyCurrencyChange")
    public CurrencyExchange applyCurrencyChange(@RequestBody CurrencyChangeRequest request) {

        return currencyChangeService.aplyCurrencyChange(request);

    }

    @GetMapping(value = "/addCurrencyValues")
    public void addCurrencyValues() {

        currencyChangeService.insertData();

    }

    @PostMapping(value = "/addCurrencyValues")
    public ResponseEntity<Void> addValue(@RequestBody CurrencyExchange request) {
        currencyChangeService.insertOneCurrencyValue(request);
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/getList")
    public List<CurrencyExchange> getAllProducts() {
        return currencyChangeService.getList();
    }

}
