package com.myrealstock.dashboard.presentation.dto;


import com.myrealstock.dashboard.domain.DetailStockInfoCrawl;
import com.myrealstock.dashboard.domain.SimpleStockInfoCrawl;
import com.myrealstock.dashboard.domain.UserStockInfo;

public class SimpleStockInfoResponseDto {

    private String stockName;
    private Integer stockNum;
    private Long average;
    private String nowPrice;

    private String profit;  // 수익
    private String profitMargin;    //수익률


    public SimpleStockInfoResponseDto(SimpleStockInfoCrawl simpleStockInfoCrawl, UserStockInfo userStockInfo) {
        this.stockName = userStockInfo.getStockName();
        this.stockNum = userStockInfo.getStockNum();
        this.average = userStockInfo.getAverage();
        this.nowPrice = simpleStockInfoCrawl.getNowPrice();
        Long nowPrice = Long.parseLong(this.nowPrice);
        this.profitMargin = (nowPrice - this.average) / average * 100 + "%";
        this.profit = Long.toString((nowPrice * stockNum) - (average * stockNum));

    }
}
