package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.PortfolioStockInfo;
import lombok.Getter;

@Getter
public class RemoveStockResponseDto {

    private Long userId;
    private Long portfolioId;
    private String ticker;

    public RemoveStockResponseDto(Long userId, PortfolioStockInfo portfolioStockInfo) {
        this.userId = userId;
        this.portfolioId = portfolioStockInfo.getPortfolioId();
        this.ticker = portfolioStockInfo.getTicker();
    }

}
