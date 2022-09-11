package com.myrealstock.portfolio.presentation;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PortfolioListResponseDto {

    private ArrayList<String> portfolioNames;

    PortfolioListResponseDto of() {
        return null;
    }
}
