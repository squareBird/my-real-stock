package com.myrealstock.portfolio.domain;

public class PortfolioNotFoundException extends RuntimeException{

    public PortfolioNotFoundException() {
        super("포트폴리오를 찾을수 없습니다.");
    }
}
