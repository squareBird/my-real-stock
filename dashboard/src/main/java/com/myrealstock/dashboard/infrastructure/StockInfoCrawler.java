package com.myrealstock.dashboard.infrastructure;

import com.myrealstock.dashboard.config.StockInfoFeignConfig;
import com.myrealstock.dashboard.domain.DetailStockInfoCrawl;

import com.myrealstock.dashboard.domain.SearchStockInfoCrawl;
import com.myrealstock.dashboard.domain.SimpleStockInfoCrawl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "StockInfoFeignClient", url = "localhost:3000/api", configuration = StockInfoFeignConfig.class)
public interface StockInfoCrawler {

    @GetMapping(value = "/detail/{stockName}", consumes = "application/json", produces = "application/json")
    DetailStockInfoCrawl searchDetailStockInfo(@PathVariable("stockName") String stockName);

    @GetMapping(value = "/simple/{stockName}", consumes = "application/json", produces = "application/json")
    SimpleStockInfoCrawl searchSimpleStockInfo(@PathVariable("stockName") String stockName);

    @GetMapping(value = "/check/{stockName}", consumes = "application/json", produces = "application/json")
    Boolean checkValidateStockName(@PathVariable("stockName") String stockName);

    @GetMapping(value = "/search/{stockName}", consumes = "application/json", produces = "application/json")
    List<SearchStockInfoCrawl> searchStockInfo(@PathVariable("stockName") String stockName);
}
