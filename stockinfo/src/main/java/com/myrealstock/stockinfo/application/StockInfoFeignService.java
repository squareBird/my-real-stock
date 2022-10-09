package com.myrealstock.stockinfo.application;

import com.myrealstock.stockinfo.presentation.StockInfoDto;
import com.myrealstock.stockinfo.infrastructure.StockInfoFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockInfoFeignService {

    private final StockInfoFeignClient stockInfoFeignClient;

    public StockInfoDto getStockInfo(String stockName) {
        StockInfoDto stockInfoDto = stockInfoFeignClient.getStockInfo(stockName);
        return stockInfoDto;
    }
}
