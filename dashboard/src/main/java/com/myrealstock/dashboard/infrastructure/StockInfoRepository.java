package com.myrealstock.dashboard.infrastructure;

import com.myrealstock.dashboard.domain.UserStockInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockInfoRepository extends JpaRepository<UserStockInfo, Long> {

    List<UserStockInfo> findByUserId(String userId);

}
