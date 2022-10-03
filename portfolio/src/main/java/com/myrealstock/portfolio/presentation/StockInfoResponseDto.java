package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.StockInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockInfoResponseDto {

    private String ticker;
    private Double price;

    public StockInfo dtoToEntity() {
        return new StockInfo(ticker, price);
    }

}