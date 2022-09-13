package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.PortfolioStockInfo;
import lombok.Getter;

@Getter
public class AddStockResponseDto {

    private Long userId;
    private Long portfolioId;
    private String ticker;
    private Integer count;
    private Double price;

    public AddStockResponseDto(Long userId, PortfolioStockInfo portfolioStockInfo) {
        this.userId = userId;
        this.portfolioId = portfolioStockInfo.getPortfolioId();
        this.ticker = portfolioStockInfo.getTicker();
        this.count = portfolioStockInfo.getCount();
        this.price = portfolioStockInfo.getPrice();
    }


}
