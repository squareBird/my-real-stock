package com.myrealstock.stockinfo.application;

import com.myrealstock.stockinfo.presentation.StockInfoResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StockInfoService {

    private static String API_TOKEN = "pk_f5efee22230942b18390aa8adb6f670f";

    public StockInfoResponseDto findStockInfo(String ticker){

//        URL url = new URL("https://cloud.iexapis.com/stable/stock/"+ ticker + "/book?token=" + API_TOKEN);
//        HttpsURLConnection https = (HttpsURLConnection) url.openConnection();

        return new StockInfoResponseDto(ticker, 200.1);

    }

}
