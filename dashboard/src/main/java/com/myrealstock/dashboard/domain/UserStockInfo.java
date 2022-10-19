package com.myrealstock.dashboard.domain;

import com.myrealstock.dashboard.presentation.dto.UpdateInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Builder
@Entity
@Table(name = "USERSTOCKINFO")
@AllArgsConstructor
@NoArgsConstructor
public class UserStockInfo {

    public UserStockInfo(String userId, String stockName, Integer stockNum, Double average) {
        this.userId = userId;
        this.stockName = stockName;
        this.stockNum = stockNum;
        this.average = average;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERID")
    private String userId;  // 유저 id
    @Column(name = "STOCKNAME")
    private String stockName;   // 주식 이름
    @Column(name = "STOCKNUM")
    private Integer stockNum; // 보유 수량
    @Column(name = "AVERAGE")
    private Double average;    // 평단가

    private LocalDateTime createdAt;

    public UserStockInfo updateInfo(String userId, String stockName, UpdateInfoDto updateInfoDto) {
        UserStockInfo userStockInfo = UserStockInfo.builder()
                .id(this.id)
                .userId(userId)
                .stockName(stockName)
                .stockNum(updateInfoDto.getStockNum())
                .average(updateInfoDto.getAverage())
                .createdAt(this.createdAt)
                .build();

        return userStockInfo;
    }


}
