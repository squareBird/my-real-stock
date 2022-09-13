package com.myrealstock.portfolio.domain;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    private String portfolioName;

}
