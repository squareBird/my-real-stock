package com.myrealstock.dashboard.presentation.dto;


import com.myrealstock.dashboard.domain.SimpleStockInfoCrawl;
import com.myrealstock.dashboard.domain.UserStockInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

@Getter
@Setter
public class SimpleStockInfoResponseDto {

    private String stockName;
    private Integer stockNum;
    private Double average;
    private String nowPrice;
    private String profit;  // 수익
    private String profitMargin;    //수익률


    public SimpleStockInfoResponseDto(SimpleStockInfoCrawl simpleStockInfoCrawl, UserStockInfo userStockInfo) {
        this.stockName = userStockInfo.getStockName();
        this.stockNum = userStockInfo.getStockNum();
        this.average = userStockInfo.getAverage();
        this.nowPrice = simpleStockInfoCrawl.getNowPrice();

        BigDecimal nowPrice = new BigDecimal(this.nowPrice.replace(",", ""));
        BigDecimal average = new BigDecimal(Double.toString(this.average));
        BigDecimal stockNum = new BigDecimal(Integer.toString(this.stockNum));
        BigDecimal ONE_HUNDRED = new BigDecimal("100");
        this.profit = ((nowPrice.multiply(stockNum)).subtract(average.multiply(stockNum))).toString();
        this.profitMargin = (((nowPrice.subtract(average)).divide(average, 2, HALF_EVEN)).multiply(ONE_HUNDRED)).toString() + "%";


//        Double nowPrice = Double.parseDouble(this.nowPrice.replace(",", ""));
//        this.profit = Double.toString((nowPrice * stockNum) - (average * stockNum));
//        this.profitMargin = (nowPrice - this.average) / average * 100 + "%";
    }
}
