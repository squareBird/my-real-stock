package com.myrealstock.stockinfo.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockInfoResponseDto {

    private String ticker;
    private Double price;

}
