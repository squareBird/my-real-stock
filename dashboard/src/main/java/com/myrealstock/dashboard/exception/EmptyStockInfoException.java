package com.myrealstock.dashboard.exception;

public class EmptyStockInfoException extends DashBoardException {
    public EmptyStockInfoException(){
        super("관심 등록한 주식이 없습니다.");
    }
}
