package com.myrealstock.stockinfo.presentation;

import com.myrealstock.stockinfo.application.StockInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class StockInfoController {

    private final StockInfoService stockInfoService;

    @RequestMapping(value = "/stock/{ticker}", method = RequestMethod.GET)
    public ResponseEntity stockInfo(@PathVariable String ticker){

        StockInfoResponseDto stockInfoResponseDto = stockInfoService.findStockInfo(ticker);

        return new ResponseEntity(stockInfoResponseDto, HttpStatus.OK);
    }

}