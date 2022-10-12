package com.myrealstock.dashboard.presentation.dto;

import com.myrealstock.dashboard.domain.DetailStockInfoCrawl;
import com.myrealstock.dashboard.domain.UserStockInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

@Getter
@Setter
public class DetailStockInfoResponseDto {

    private String stockName;   // 주식 이름
    private Integer stockNum; // 보유 수량
    private Double average;    // 평단가
    private String nowPrice;
    private String profit;  // 수익
    private String profitMargin;    //수익률
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

        BigDecimal nowPrice = new BigDecimal(this.nowPrice.replace(",", ""));
        BigDecimal average = new BigDecimal(Double.toString(this.average));
        BigDecimal stockNum = new BigDecimal(Integer.toString(this.stockNum));
        BigDecimal ONE_HUNDRED = new BigDecimal("100");
        this.profit = ((nowPrice.multiply(stockNum)).subtract(average.multiply(stockNum))).toString();
        this.profitMargin = (((nowPrice.subtract(average)).divide(average, 2, HALF_EVEN)).multiply(ONE_HUNDRED)).toString() + "%";

//        Double nowPrice = Double.parseDouble(this.nowPrice.replace(",", ""));
//        this.profit = Double.toString((nowPrice * stockNum) - (average * stockNum));
//        this.profitMargin = (nowPrice - this.average) / average * 100 + "%";
        this.compareNum = detailStockInfoCrawl.getCompareNum();
        this.percentage = detailStockInfoCrawl.getPercentage();
        this.price1 = detailStockInfoCrawl.getPrice1();
        this.price2 = detailStockInfoCrawl.getPrice2();
        this.price3 = detailStockInfoCrawl.getPrice3();
        this.price4 = detailStockInfoCrawl.getPrice4();
        this.price5 = detailStockInfoCrawl.getPrice5();
    }

}
