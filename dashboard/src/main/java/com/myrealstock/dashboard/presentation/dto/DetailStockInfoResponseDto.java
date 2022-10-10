package com.myrealstock.dashboard.presentation.dto;

import com.myrealstock.dashboard.domain.DetailStockInfoCrawl;
import com.myrealstock.dashboard.domain.UserStockInfo;

public class DetailStockInfoResponseDto {

    private String stockName;   // 주식 이름
    private Integer stockNum; // 보유 수량
    private Long average;    // 평단가
    private String nowPrice;
    private String compareNum;
    private String percentage;
    private String price1;
    private String price2;
    private String price3;
    private String price4;
    private String price5;

    // Entity -> DTO
    public DetailStockInfoResponseDto(DetailStockInfoCrawl detailStockInfoCrawl, UserStockInfo userStockInfo) {
        this.stockName = userStockInfo.getStockName();
        this.stockNum = userStockInfo.getStockNum();
        this.average = userStockInfo.getAverage();
        this.nowPrice = detailStockInfoCrawl.getNowPrice();
        this.compareNum = detailStockInfoCrawl.getCompareNum();
        this.percentage = detailStockInfoCrawl.getPercentage();
        this.price1 = detailStockInfoCrawl.getPrice1();
        this.price2 = detailStockInfoCrawl.getPrice2();
        this.price3 = detailStockInfoCrawl.getPrice3();
        this.price4 = detailStockInfoCrawl.getPrice4();
        this.price5 = detailStockInfoCrawl.getPrice5();
    }

}
