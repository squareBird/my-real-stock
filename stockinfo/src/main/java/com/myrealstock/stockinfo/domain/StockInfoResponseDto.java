package com.myrealstock.stockinfo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockInfoResponseDto {

    String ticker;
    Double price;

}
