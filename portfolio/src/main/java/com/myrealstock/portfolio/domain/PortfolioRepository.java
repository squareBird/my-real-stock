package com.myrealstock.portfolio.domain;

import java.util.List;

public interface PortfolioRepository {

    public void saveNewPortfolio(PortfolioInfo portfolioInfo);
    public List<PortfolioInfo> findPortfolioInfoByUserName(String userName);

}
