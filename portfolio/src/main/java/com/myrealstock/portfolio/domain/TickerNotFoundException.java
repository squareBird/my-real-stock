package com.myrealstock.portfolio.domain;

public class TickerNotFoundException extends RuntimeException{

    public TickerNotFoundException() {
        super("해당 Ticker를 찾을 수 없습니다.");
    }
}
