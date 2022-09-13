package com.myrealstock.portfolio.domain;

import com.myrealstock.portfolio.presentation.ExtendStockRequestDto;

import java.util.List;

public interface PortfolioRepository {

    void saveNewPortfolio(PortfolioInfo portfolioInfo);

    void saveNewPortfolioStock(PortfolioStockInfo portfolioStockInfo);

    List<PortfolioInfo> findPortfolioInfoListByUserId(Long userId);

    //    public void extendsStock(String userToken, PortfolioStockInfo portfolioStockInfo);


}
