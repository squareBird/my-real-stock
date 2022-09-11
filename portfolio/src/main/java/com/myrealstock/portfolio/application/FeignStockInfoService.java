package com.myrealstock.portfolio.application;

import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignStockInfoService {

    private final FeignStockInfoInterface feignStockInfoInterface;

    @Autowired
    public FeignStockInfoService(FeignStockInfoInterface feignStockInfoInterface) {
        this.feignStockInfoInterface = feignStockInfoInterface;
    }

    public StockInfoResponseDto getStockInfo(String ticker) {
        return feignStockInfoInterface.getStockInfo(ticker);
    }

}
