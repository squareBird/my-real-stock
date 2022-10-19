package com.myrealstock.dashboard.presentation.dto;

import com.myrealstock.dashboard.domain.UserStockInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UpdateInfoDto {

    private Integer stockNum;
    private Double average;

    public UserStockInfo dtoToEntity(String userId, String stockName) {
        UserStockInfo userStockInfo = UserStockInfo.builder()
                .userId(userId)
                .stockName(stockName)
                .stockNum(this.stockNum)
                .average(this.average)
                .createdAt(LocalDateTime.now())
                .build();

        return userStockInfo;
    }

}
