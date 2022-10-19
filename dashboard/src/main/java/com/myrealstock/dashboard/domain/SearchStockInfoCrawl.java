package com.myrealstock.dashboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchStockInfoCrawl {

    private String stockName;
    private String nowPrice;
    private String price1;
    private String price2;
    private String price3;
    private String price4;
    private String price5;
    private String price6;
}
