package com.backend.prueba.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Omar Corahua
 * @FileName: CurrencyChangeEntity.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */

@Data
@Entity
@Table(name = "CURRENCY_EXCHANGE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"MONEDA_ORIGEN", "MONEDA_DESTINO", "TIPO_CAMBIO"})
})
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MONTO", nullable = false, precision = 19, scale = 4)
    private BigDecimal monto;

    @Column(name = "MONTO_CON_TIPO_CAMBIO", nullable = false, precision = 19, scale = 4)
    private BigDecimal montoConTipoCambio;

    @Column(name = "MONEDA_ORIGEN", length = 3, nullable = false)
    private String monedaOrigen;

    @Column(name = "MONEDA_DESTINO", length = 3, nullable = false)
    private String monedaDestino;

    @Column(name = "TIPO_CAMBIO", nullable = false, precision = 19, scale = 6)
    private BigDecimal tipoCambio;

}
