package com.myrealstock.portfolio.infrastructure;

import com.myrealstock.portfolio.domain.StockInfo;
import com.myrealstock.portfolio.domain.StockInfoRepository;
import com.myrealstock.portfolio.presentation.StockInfoRequestDto;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import org.springframework.context.annotation.Profile;

@Profile("db")
public class StockInfoDBRepository implements StockInfoRepository {

    @Override
    public StockInfo getStockInfo(StockInfoRequestDto stockInfoRequestDto) {
        return null;
    }


}
