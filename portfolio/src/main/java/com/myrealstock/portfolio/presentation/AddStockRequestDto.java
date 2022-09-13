package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.PortfolioStockInfo;
import lombok.Getter;

@Getter
public class AddStockRequestDto {

    private Long portfolioId;
    private String ticker;
    private Integer count;
    private Double price;

    public PortfolioStockInfo dtoToEntity() {

        PortfolioStockInfo portfolioStockInfo = new PortfolioStockInfo(
                null,
                this.portfolioId,
                this.ticker,
                this.count,
                this.price
        );

        return portfolioStockInfo;
    }

}
