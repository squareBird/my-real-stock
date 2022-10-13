package com.myrealstock.dashboard.exception;

public class CantSaveMoreThanFiveStockInfoException extends DashBoardException{

    public CantSaveMoreThanFiveStockInfoException() {
        super("관심 종목은 5개를 초과할 수 없습니다.");
    }

}
