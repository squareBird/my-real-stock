package com.myrealstock.portfolio.domain;

import java.util.List;

public interface PortfolioRepository {

    void saveNewPortfolioInfo(PortfolioInfo portfolioInfo);

    void addPortfolioStockInfo(PortfolioStockInfo portfolioStockInfo);

    List<PortfolioInfo> findPortfolioInfoListByUserId(Long userId);

    PortfolioStockInfo removePortfolioStockInfo(Long userId, Long portfolioId, String ticker);

    PortfolioStockInfo modifyPortfolioStockInfo();

    //    public void extendsStock(String userToken, PortfolioStockInfo portfolioStockInfo);


}
