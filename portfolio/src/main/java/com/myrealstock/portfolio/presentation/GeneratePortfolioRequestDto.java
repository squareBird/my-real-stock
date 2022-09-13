package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import lombok.Getter;

@Getter
public class GeneratePortfolioRequestDto {

    private String portfolioName;

    public PortfolioInfo dtoToEntity(Long userId) {

        PortfolioInfo portfolioInfo = new PortfolioInfo(
                null,
                userId,
                this.portfolioName
        );

        return portfolioInfo;
    }

}
