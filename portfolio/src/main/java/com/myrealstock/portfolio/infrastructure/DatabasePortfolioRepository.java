package com.myrealstock.portfolio.infrastructure;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import com.myrealstock.portfolio.domain.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void saveNewPortfolio(PortfolioInfo portfolioInfo) {
        em.persist(portfolioInfo);
    }

    public List<PortfolioInfo> findPortfolioInfoByUserName(String userName) {

        List<PortfolioInfo> result = em
                .createQuery("select p from PortfolioInfo p where p.userName = :userName", PortfolioInfo.class)
                .setParameter("userName", userName)
                .getResultList();

        return result;

    }
}
