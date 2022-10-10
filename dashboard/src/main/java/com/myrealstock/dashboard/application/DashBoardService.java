package com.myrealstock.dashboard.application;

import com.myrealstock.dashboard.domain.DetailStockInfoCrawl;
import com.myrealstock.dashboard.domain.SimpleStockInfoCrawl;
import com.myrealstock.dashboard.domain.UserStockInfo;
import com.myrealstock.dashboard.infrastructure.StockInfoCrawler;
import com.myrealstock.dashboard.infrastructure.StockInfoRepository;
import com.myrealstock.dashboard.presentation.dto.DetailStockInfoResponseDto;
import com.myrealstock.dashboard.presentation.dto.SimpleStockInfoResponseDto;
import com.myrealstock.dashboard.presentation.dto.UserStockInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DashBoardService {

    private final StockInfoRepository stockInfoRepository;
    private final StockInfoCrawler stockInfoCrawler;

    // 주식 이름으로 주식 상세 정보 크롤링
    public DetailStockInfoCrawl searchDetailStockInfo(String stockName) {
        DetailStockInfoCrawl detailStockInfoCrawl = stockInfoCrawler.searchDetailStockInfo(stockName);
        return detailStockInfoCrawl;
    }

    // 주식 이름으로 주식 간단 정보 크롤링
    public SimpleStockInfoCrawl searchSimpleStockInfo(String stockName) {
        SimpleStockInfoCrawl simpleStockInfoCrawl = stockInfoCrawler.searchSimpleStockInfo(stockName);
        return simpleStockInfoCrawl;
    }

    // 사용자가 입력한 값(주식이름, 수량, 평단가) DB 저장
    public void saveStockInfo(UserStockInfoDto userStockInfoDto) {
        UserStockInfo userStockInfo = userStockInfoDto.dtoToEntity();
        stockInfoRepository.save(userStockInfo);
    }

    // 사용자 대시보드 화면 가져오기
    public List<SimpleStockInfoResponseDto> getUserDashBoardStockInfo(String userId) {
        List<UserStockInfo> userStockInfoList = findUserStockInfo(userId);
        checkListIsEmpty(userStockInfoList);
        List<SimpleStockInfoResponseDto> simpleStockInfoResponseDtoList = new ArrayList<>();
        for(int i = 0; i < userStockInfoList.size(); i++ ) {
            SimpleStockInfoCrawl simpleStockInfoCrawl = searchSimpleStockInfo(userStockInfoList.get(i).getStockName());
            simpleStockInfoResponseDtoList.add(new SimpleStockInfoResponseDto(simpleStockInfoCrawl, userStockInfoList.get(i)));
        }

        return simpleStockInfoResponseDtoList;
    }

    // 사용자 포트폴리오 화면 가져오기
    public List<DetailStockInfoResponseDto> getUserPortfolioStockInfo(String userId) {
        List<UserStockInfo> userStockInfoList = findUserStockInfo(userId);
        checkListIsEmpty(userStockInfoList);
        List<DetailStockInfoResponseDto> detailStockInfoResponseDtoList = new ArrayList<>();

        for(int i = 0; i < userStockInfoList.size(); i++ ) {
            DetailStockInfoCrawl detailStockInfoCrawl = searchDetailStockInfo(userStockInfoList.get(i).getStockName());
            detailStockInfoResponseDtoList.add(new DetailStockInfoResponseDto(detailStockInfoCrawl, userStockInfoList.get(i)));
        }

        return detailStockInfoResponseDtoList;
    }

    // 사용자가 입력한 값(주식이름, 수량, 평단가) DB 에서 가져오기
    private List<UserStockInfo> findUserStockInfo(String userId) {
        return stockInfoRepository.findByUserId(userId);
    }

    // 사용자 입력 값 불러오기 검증 -> DB 에 저장된 값이 있는지 없는지 확인
    private void checkListIsEmpty(List<UserStockInfo> userStockInfoList) {
        if(userStockInfoList == null) {
            throw new RuntimeException();
        }
    }


}
