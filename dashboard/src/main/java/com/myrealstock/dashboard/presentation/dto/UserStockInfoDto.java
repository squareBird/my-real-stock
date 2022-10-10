package com.myrealstock.dashboard.presentation.dto;

import com.myrealstock.dashboard.domain.UserStockInfo;

import java.time.LocalDateTime;

public class UserStockInfoDto {

    private String userId;
    private String stockName;
    private Integer stockNum;
    private Long average;

    public UserStockInfo dtoToEntity() {
        UserStockInfo userStockInfo = UserStockInfo.builder()
                .userId(this.userId)
                .stockName(this.stockName)
                .stockNum(this.stockNum)
                .average(this.average)
                .createdAt(LocalDateTime.now())
                .build();

        return userStockInfo;
    }

}
