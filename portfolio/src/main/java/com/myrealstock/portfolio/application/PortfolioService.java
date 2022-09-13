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

    private void validPortfolio(Long userId, Long portfolioId) {

        List<Long> userPortfolioList = portfolioRepository.findPortfolioInfoListByUserId(userId)
                .stream()
                .map(x->x.getId())
                .toList();

        if(!userPortfolioList.contains(portfolioId))
            throw new PortfolioNotFoundException();

    }

    // 해당 티커가 존재하는지 검증
    private void validTicker(String ticker) {
        stockInfoService.getStockInfo(new StockInfoRequestDto(ticker));
    }

    // 로그인 정보가 확인되어야 추가 가능..
    // userToken을 통해받아온 userId와 DTO내부의 userId가 일치할 경우에만 추가
    public GeneratePortfolioResponseDto generatePortfolio(String userToken, GeneratePortfolioRequestDto generatePortfolioRequestDto) {

        Long userId = getUserId(userToken);

        PortfolioInfo portfolioInfo = generatePortfolioRequestDto.dtoToEntity(userId);
        portfolioRepository.saveNewPortfolioInfo(portfolioInfo);

        return new GeneratePortfolioResponseDto(portfolioInfo);

    }

    public List<String> getPortfolioInfoList(String userToken) {

        Long userId = getUserId(userToken);

        List<String> result = portfolioRepository.findPortfolioInfoListByUserId(userId)
                .stream()
                .map(x->x.getPortfolioName())
                .toList();

        return result;

    }

    public AddStockResponseDto addStock(String userToken, AddStockRequestDto addStockRequestDto) {

        Long userId = getUserId(userToken);

        // User가 가지고 있는 포트폴리오 정보가 맞는지 검증
        validPortfolio(userId, addStockRequestDto.getPortfolioId());
        validTicker(addStockRequestDto.getTicker());

        PortfolioStockInfo portfolioStockInfo = addStockRequestDto.dtoToEntity();
        portfolioRepository.addPortfolioStockInfo(portfolioStockInfo);

        return new AddStockResponseDto(userId, portfolioStockInfo);

    }

    public RemoveStockResponseDto removeStock(String userToken, RemoveStockRequestDto removeStockRequestDto) {

        Long userId = getUserId(userToken);

        validPortfolio(userId, removeStockRequestDto.getPortfolioId());

        PortfolioStockInfo portfolioStockInfo = portfolioRepository.
                removePortfolioStockInfo(userId, removeStockRequestDto.getPortfolioId(), removeStockRequestDto.getTicker());

        return new RemoveStockResponseDto(userId, portfolioStockInfo);

    }

    public void showPortfolioDetail(String userToken) {
        // 특정 포트롤리오 리스트를 가져옴

        // 포트폴리오 리스트의 주식 티커를 가져옴
        // 티커를 가져와서 stockInfo API와 연동해 실시간 주식 정보 및 배당 정보 등을 받아옴
        // 금액계산

        // 정리해서 보여주
    }

}
