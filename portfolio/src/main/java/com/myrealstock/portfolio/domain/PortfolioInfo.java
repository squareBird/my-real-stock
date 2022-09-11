package com.myrealstock.portfolio.domain;

import com.myrealstock.portfolio.presentation.GeneratePortfolioRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 포트폴리오 이름
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioInfo {

    public PortfolioInfo(GeneratePortfolioRequestDto generatePortfolioRequestDto) {
        this.portfolioName = generatePortfolioRequestDto.getPortfolioName();
        this.userName = generatePortfolioRequestDto.getUserName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;
    private String portfolioName;

}
