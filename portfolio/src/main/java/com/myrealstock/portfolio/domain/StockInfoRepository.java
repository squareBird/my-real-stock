package com.myrealstock.portfolio.domain;

import com.myrealstock.portfolio.presentation.StockInfoRequestDto;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;

public interface StockInfoRepository {

    // 도메인 계층은 Entity를 다뤄야 한다. Dto를 다루면 안된다.
    StockInfo getStockInfo(StockInfoRequestDto stockInfoRequestDto);

}