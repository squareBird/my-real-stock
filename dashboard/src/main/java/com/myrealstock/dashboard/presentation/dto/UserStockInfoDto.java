package com.myrealstock.dashboard.presentation.dto;

import com.myrealstock.dashboard.domain.UserStockInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserStockInfoDto {

    private String userId;
    private String stockName;
    private Integer stockNum;
    private Double average;

    public UserStockInfo dtoToEntity() {
        UserStockInfo userStockInfo = UserStockInfo.builder()
                .userId(this.userId)
                .stockName(this.stockName)
                .stockNum(this.stockNum)
                .average(this.average)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        return userStockInfo;
    }

}
