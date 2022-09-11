package com.myrealstock.portfolio.infrastructure;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import com.myrealstock.portfolio.domain.PortfolioRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("test")
public class MemoryPortfolioRepository implements PortfolioRepository {
    @Override
    public void saveNewPortfolio(PortfolioInfo portfolioInfo) {

    }

    @Override
    public List<PortfolioInfo> findPortfolioInfoByUserName(String userName) {
        return null;
    }
}
