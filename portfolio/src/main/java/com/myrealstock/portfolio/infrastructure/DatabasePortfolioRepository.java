package com.myrealstock.portfolio.infrastructure;

import com.myrealstock.portfolio.domain.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
@Profile("prod")
public class DatabasePortfolioRepository implements PortfolioRepository {

    private final EntityManager em;

    @Autowired
    public DatabasePortfolioRepository(EntityManager em) {
        this.em = em;
    }

}
