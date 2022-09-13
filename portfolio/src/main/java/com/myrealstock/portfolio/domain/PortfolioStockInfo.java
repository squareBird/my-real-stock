package com.myrealstock.portfolio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 포트폴리오에 들어있는 주식 정보
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioStockInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long portfolioId;
    private String ticker;
    private Integer count;
    private Double price;

}
