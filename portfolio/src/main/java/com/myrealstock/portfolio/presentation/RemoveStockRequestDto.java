package com.myrealstock.portfolio.presentation;

import lombok.Getter;

@Getter
public class RemoveStockRequestDto {

    private Long portfolioId;
    private String ticker;

}
