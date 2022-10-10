package com.myrealstock.dashboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStockInfo {

    public UserStockInfo(String userId, String stockName, Integer stockNum, Long average) {
        this.userId = userId;
        this.stockName = stockName;
        this.stockNum = stockNum;
        this.average = average;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;  // 유저 id
    private String stockName;   // 주식 이름
    private Integer stockNum; // 보유 수량
    private Long average;    // 평단가

    private LocalDateTime createdAt;


}
