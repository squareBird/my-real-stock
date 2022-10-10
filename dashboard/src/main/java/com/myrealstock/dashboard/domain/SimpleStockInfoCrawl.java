package com.myrealstock.dashboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleStockInfoCrawl {

    private String stockName;
    private String nowPrice;

}
