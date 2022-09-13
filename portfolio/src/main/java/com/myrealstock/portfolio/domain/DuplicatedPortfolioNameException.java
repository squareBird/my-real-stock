package com.myrealstock.portfolio.domain;

public class DuplicatedPortfolioNameException extends RuntimeException{

    public DuplicatedPortfolioNameException() {
        super("이미 존재하는 포트폴리오 이름입니다.");
    }

}
