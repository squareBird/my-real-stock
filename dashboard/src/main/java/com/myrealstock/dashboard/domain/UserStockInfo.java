package com.myrealstock.dashboard.domain;

import com.myrealstock.dashboard.exception.CantSaveUnderZeroValueInStockNumAndAverageException;
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

    private LocalDateTime modifiedAt;

    public UserStockInfo updateInfo(String userId, String stockName, UpdateInfoDto updateInfoDto) {
        // 입력 값 검증(주식 갯수, 평단가가 0보다 작으면 안됨)
        checkValidateStockNumAndAverage(updateInfoDto);

        UserStockInfo userStockInfo = UserStockInfo.builder()
                .id(this.id)
                .userId(userId)
                .stockName(stockName)
                .stockNum(updateInfoDto.getStockNum())
                .average(updateInfoDto.getAverage())
                .createdAt(this.createdAt)
                .modifiedAt(LocalDateTime.now())
                .build();

        return userStockInfo;
    }

    private void checkValidateStockNumAndAverage(UpdateInfoDto updateInfoDto) {
        if(updateInfoDto.getStockNum() <= Constants.MIN || updateInfoDto.getAverage() <= Constants.MIN) {
            throw new CantSaveUnderZeroValueInStockNumAndAverageException();
        }
    }

}
