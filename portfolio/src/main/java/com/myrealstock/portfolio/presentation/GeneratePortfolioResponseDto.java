package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import lombok.Getter;

@Getter
public class GeneratePortfolioResponseDto {

    private Long userId;
    private String portfolioName;

    public GeneratePortfolioResponseDto(PortfolioInfo portfolioInfo) {
        this.userId = portfolioInfo.getUserId();
        this.portfolioName = portfolioInfo.getPortfolioName();
    }

}
