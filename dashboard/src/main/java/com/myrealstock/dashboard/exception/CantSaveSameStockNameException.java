package com.myrealstock.dashboard.exception;

public class CantSaveSameStockNameException extends DashBoardException{

    public CantSaveSameStockNameException() {
        super("이미 등록되어 있는 종목입니다.");
    }

}
