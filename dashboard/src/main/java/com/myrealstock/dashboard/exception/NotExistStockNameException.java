package com.myrealstock.dashboard.exception;

public class NotExistStockNameException extends DashBoardException{

    public NotExistStockNameException() {
        super("존재하지 않는 종목입니다.");
    }

}
