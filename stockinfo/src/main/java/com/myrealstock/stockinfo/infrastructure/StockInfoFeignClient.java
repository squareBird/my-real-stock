package com.myrealstock.stockinfo.infrastructure;

import com.myrealstock.stockinfo.config.StockInfoFeignConfig;
import com.myrealstock.stockinfo.presentation.StockInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "StockInfoFeignClient", url = "localhost:3000/api", configuration = StockInfoFeignConfig.class)
public interface StockInfoFeignClient {

    @GetMapping(value = "/{stockName}", consumes = "application/json", produces = "application/json")
    StockInfoDto getStockInfo(@PathVariable("stockName") String stockName);
}
