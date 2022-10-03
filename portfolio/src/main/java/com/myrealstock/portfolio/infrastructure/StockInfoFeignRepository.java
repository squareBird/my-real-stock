package com.myrealstock.portfolio.infrastructure;

import com.myrealstock.portfolio.domain.StockInfo;
import com.myrealstock.portfolio.domain.StockInfoRepository;
import com.myrealstock.portfolio.infrastructure.StockInfoInterface;
import com.myrealstock.portfolio.presentation.StockInfoRequestDto;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockInfoFeignRepository implements StockInfoRepository {

    private final StockInfoInterface stockInfoInterface;

    public StockInfo getStockInfo(StockInfoRequestDto stockInfoRequestDto) {

        StockInfo stockInfo = stockInfoInterface.getStockInfo(stockInfoRequestDto).dtoToEntity();

        return stockInfo;

    }

}
