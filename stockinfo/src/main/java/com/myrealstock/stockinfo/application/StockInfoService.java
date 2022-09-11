package com.myrealstock.stockinfo.application;

import com.myrealstock.stockinfo.domain.StockInfoResponseDto;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class StockInfoService {

    private static String API_TOKEN = "pk_f5efee22230942b18390aa8adb6f670f";

    public StockInfoResponseDto findStockInfo(String ticker){

//        URL url = new URL("https://cloud.iexapis.com/stable/stock/"+ ticker + "/book?token=" + API_TOKEN);
//        HttpsURLConnection https = (HttpsURLConnection) url.openConnection();

        return new StockInfoResponseDto("aapl", 200.1);

    }

}
