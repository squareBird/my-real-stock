package com.myrealstock.dashboard.exception;

public class CantSaveUnderZeroValueInStockNumAndAverageException extends DashBoardException {

    public CantSaveUnderZeroValueInStockNumAndAverageException() {
        super("종목 수량과 평단가는 0보다 작을 수 없습니다.");
    }
}
