package com.myrealstock.portfolio.infrastructure;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import com.myrealstock.portfolio.domain.PortfolioRepository;
import com.myrealstock.portfolio.domain.PortfolioStockInfo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
@Profile("prod")
public class DatabasePortfolioRepository implements PortfolioRepository {

    private final EntityManager em;

    @Override // 포트폴리오 정보 저장
    public void saveNewPortfolio(PortfolioInfo portfolioInfo) {
        em.persist(portfolioInfo);
    }

    @Override
    public void saveNewPortfolioStock(PortfolioStockInfo portfolioStockInfo) {
        em.persist(portfolioStockInfo);
    }

    @Override
    public List<PortfolioInfo> findPortfolioInfoListByUserId(Long userId) {

        List<PortfolioInfo> result = em
                .createQuery("select p from PortfolioInfo p where p.userId = :userId", PortfolioInfo.class)
                .setParameter("userId", userId)
                .getResultList();

        return result;

    }

}
