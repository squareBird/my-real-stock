package com.myrealstock.portfolio.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StockInfo {

    private String ticker;
    private Double price;

    Double totalPrice(int count) {
        return count * price;
    }

}
