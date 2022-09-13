package com.myrealstock.portfolio.stockinfo;

import com.myrealstock.portfolio.presentation.StockInfoRequestDto;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockInfoService {

    private final StockInfoInterface stockInfoInterface;

    public StockInfoResponseDto getStockInfo(StockInfoRequestDto stockInfoRequestDto) {
        return stockInfoInterface.getStockInfo(stockInfoRequestDto);
    }

}
