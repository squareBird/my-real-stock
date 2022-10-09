package com.myrealstock.stockinfo.presentation;

import com.myrealstock.stockinfo.application.StockInfoFeignService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class StockInfoFeignController {

    private final StockInfoFeignService stockInfoFeignService;

    @GetMapping("/search/{stockName}")
    public ResponseEntity<StockInfoDto> getStockInfo(@PathVariable String stockName) {
        StockInfoDto stockInfoDto = stockInfoFeignService.getStockInfo(stockName);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "Application/json");

        return new ResponseEntity<StockInfoDto>(stockInfoDto, headers, HttpStatus.OK);
    }
}
