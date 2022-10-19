package com.myrealstock.dashboard.application;

import com.myrealstock.dashboard.domain.DetailStockInfoCrawl;
import com.myrealstock.dashboard.domain.SearchStockInfoCrawl;
import com.myrealstock.dashboard.domain.SimpleStockInfoCrawl;
import com.myrealstock.dashboard.domain.UserStockInfo;
import com.myrealstock.dashboard.exception.CantSaveMoreThanFiveStockInfoException;
import com.myrealstock.dashboard.exception.CantSaveSameStockNameException;
import com.myrealstock.dashboard.exception.EmptyStockInfoException;
import com.myrealstock.dashboard.exception.NotExistStockNameException;
import com.myrealstock.dashboard.infrastructure.StockInfoCrawler;
import com.myrealstock.dashboard.infrastructure.StockInfoRepository;
import com.myrealstock.dashboard.presentation.dto.DetailStockInfoResponseDto;
import com.myrealstock.dashboard.presentation.dto.SimpleStockInfoResponseDto;
import com.myrealstock.dashboard.presentation.dto.UpdateInfoDto;
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
    private static final Integer MAX_STOCK_INFO = 5;

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

    public List<SearchStockInfoCrawl> searchStockInfo(String stockName) {
        List<SearchStockInfoCrawl> searchStockInfoCrawlList = stockInfoCrawler.searchStockInfo(stockName);
        return searchStockInfoCrawlList;
    }

    // 사용자가 입력한 값(주식이름, 수량, 평단가) DB 저장
    public void saveStockInfo(UserStockInfoDto userStockInfoDto) {
        checkValidateStockName(userStockInfoDto.getStockName());
        checkUserStockInfoCount(userStockInfoDto.getUserId());
        checkSameUserStockInfo(userStockInfoDto.getUserId(), userStockInfoDto.getStockName());
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

    // 사용자 관심 종목 등록할 때, 종목 이름이 없는 종목일 때 예외 처리
    private void checkValidateStockName(String stockName) {
        if(!stockInfoCrawler.checkValidateStockName(stockName)) {
            throw new NotExistStockNameException();
        }
    }

    // 사용자 입력 값 불러오기 검증 -> DB 에 저장된 값이 있는지 없는지 확인
    private void checkListIsEmpty(List<UserStockInfo> userStockInfoList) {
        if(userStockInfoList == null) {
            throw new EmptyStockInfoException();
        }
    }

    // 사용자 관심 종목 등록 개수는 5개를 초과할 수 없음.
    // 관심종목을 추가하려고 할 때, DB 에서 사용자 ID로 저장되어있는 행 개수를 가져온 후, 5개라면 예외 던짐.
    private void checkUserStockInfoCount(String userId) {
        if(stockInfoRepository.countByUserId(userId) == MAX_STOCK_INFO) {
            throw new CantSaveMoreThanFiveStockInfoException();
        }
    }

    // 사용자가 입력한 값(주식이름, 수량, 평단가) DB 에서 가져오기
    private List<UserStockInfo> findUserStockInfo(String userId) {
        return stockInfoRepository.findByUserId(userId);
    }

    // 관심종목을 추가하려고 할 때, 사용자 ID와 종목이름으로 DB에 검색하여, 이미 저장되어 있다면 예외를 던짐
    private void checkSameUserStockInfo(String userId, String stockName) {
        if(stockInfoRepository.findByUserIdAndStockName(userId, stockName) != null) {
            throw new CantSaveSameStockNameException();
        }
    }

    // 관심종목에 추가된 종목들의 갯수 및 평단가 수정
    public void updateStockInfo(String userId, String stockName, UpdateInfoDto updateInfoDto) {
        UserStockInfo userStockInfo = stockInfoRepository.findByUserIdAndStockName(userId, stockName);
        userStockInfo = userStockInfo.updateInfo(userId, stockName, updateInfoDto);
        stockInfoRepository.save(userStockInfo);
    }

}
