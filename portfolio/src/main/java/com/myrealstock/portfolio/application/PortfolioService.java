package com.myrealstock.portfolio.application;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import com.myrealstock.portfolio.domain.PortfolioRepository;
import com.myrealstock.portfolio.presentation.GeneratePortfolioRequestDto;
import com.myrealstock.portfolio.presentation.PortfolioListResponseDto;
import com.myrealstock.portfolio.presentation.StockInfoRequestDto;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final com.myrealstock.portfolio.feign.StockInfoService stockInfoService;

    public StockInfoResponseDto getStockInfo(StockInfoRequestDto stockInfoRequestDto) {
        return stockInfoService.getStockInfo(stockInfoRequestDto);
    }

    // 성공하면 현재 포트폴리오 목록 반환
    public PortfolioListResponseDto generatePortfolio(GeneratePortfolioRequestDto generatePortfolioRequestDto) {

        PortfolioInfo portfolioInfo = new PortfolioInfo(generatePortfolioRequestDto);
        portfolioRepository.saveNewPortfolio(portfolioInfo);

        return null;

    }



}
