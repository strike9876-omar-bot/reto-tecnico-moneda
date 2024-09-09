package com.backend.prueba.repository;

import com.backend.prueba.entity.CurrencyExchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Omar Corahua
 * @FileName: CurrencyExchangeRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange , Long> {

}
