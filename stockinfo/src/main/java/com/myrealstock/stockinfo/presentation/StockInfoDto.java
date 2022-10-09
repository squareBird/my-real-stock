package com.myrealstock.stockinfo.presentation;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockInfoDto {

    private String name;
    private String nowPrice;
    private String compareNum;
    private String percentage;
    private String price1;
    private String price2;
    private String price3;
    private String price4;
    private String price5;
}
