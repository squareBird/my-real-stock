package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.PortfolioStockInfo;
import lombok.Getter;

@Getter
public class ExtendStockResponseDto {

    private String userToken;
    private Long portfolioId;
    private String ticker;
    private Integer count;
    private Double price;

    public ExtendStockResponseDto(String userToken, PortfolioStockInfo portfolioStockInfo) {
        this.userToken = userToken;
        this.portfolioId = portfolioStockInfo.getPortfolioId();
        this.ticker = portfolioStockInfo.getTicker();
        this.count = portfolioStockInfo.getCount();
        this.price = portfolioStockInfo.getPrice();
    }


}
