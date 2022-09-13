package com.myrealstock.portfolio.application;

import com.myrealstock.portfolio.domain.PortfolioInfo;
import com.myrealstock.portfolio.domain.PortfolioNotFoundException;
import com.myrealstock.portfolio.domain.PortfolioRepository;
import com.myrealstock.portfolio.domain.PortfolioStockInfo;
import com.myrealstock.portfolio.presentation.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


// token = 유저 정보 토큰 이 토큰으로 유저정보 가져오는 로직 필요
@Service
@AllArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final com.myrealstock.portfolio.stockinfo.StockInfoService stockInfoService;

    StockInfoResponseDto getStockInfo(StockInfoRequestDto stockInfoRequestDto) {
        return stockInfoService.getStockInfo(stockInfoRequestDto);
    }

    Long getUserId(String userToken) {
        // userToken을 활용해서 userId값 얻어오는 메소드 필요. 하지만 지금은 그냥 한다...
        return Long.valueOf(userToken);
    }

    // 로그인 정보가 확인되어야 추가 가능..
    // userToken을 통해받아온 userId와 DTO내부의 userId가 일치할 경우에만 추가
    public GeneratePortfolioResponseDto generatePortfolio(String userToken, GeneratePortfolioRequestDto generatePortfolioRequestDto) {

        PortfolioInfo portfolioInfo = generatePortfolioRequestDto.dtoToEntity(getUserId(userToken));
        portfolioRepository.saveNewPortfolio(portfolioInfo);

        return new GeneratePortfolioResponseDto(portfolioInfo);

    }

    public List<String> getPortfolioInfoList(String userToken) {

        List<String> result = portfolioRepository.findPortfolioInfoListByUserId(getUserId(userToken))
                .stream()
                .map(x->x.getPortfolioName())
                .toList();

        return result;

    }

    private void validPortfolio(String userToken, ExtendStockRequestDto extendStockRequestDto) {

        List<Long> userPortfolioList = portfolioRepository.findPortfolioInfoListByUserId(getUserId(userToken))
                .stream()
                .map(x->x.getId())
                .toList();

        if(!userPortfolioList.contains(extendStockRequestDto.getPortfolioId()))
            throw new PortfolioNotFoundException();

    }

    public ExtendStockResponseDto extendStock(String userToken, ExtendStockRequestDto extendStockRequestDto) {

        // User가 가지고 있는 포트폴리오 정보가 맞는지 검증
        validPortfolio(userToken, extendStockRequestDto);

        PortfolioStockInfo portfolioStockInfo = extendStockRequestDto.dtoToEntity();
        portfolioRepository.saveNewPortfolioStock(portfolioStockInfo);

        return new ExtendStockResponseDto(userToken, portfolioStockInfo);

    }



}
