package com.myrealstock.portfolio.application;

import com.myrealstock.portfolio.configure.FeignConfig;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "test", url="http://localhost:8080", configuration = {FeignConfig.class})
public interface FeignStockInfoInterface {

    @RequestMapping(method = RequestMethod.GET, value ="/api/stock/{ticker}")
    StockInfoResponseDto getStockInfo(@PathVariable("ticker") String ticker);

}
