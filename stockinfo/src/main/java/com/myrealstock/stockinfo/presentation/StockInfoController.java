package com.myrealstock.stockinfo.presentation;

import com.myrealstock.stockinfo.application.StockInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stock")
public class StockInfoController {

    private final StockInfoService stockInfoService;

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ResponseEntity getStockInfo(@RequestBody StockInfoRequestDto stockInfoRequestDto){

        StockInfoResponseDto stockInfoResponseDto = stockInfoService.findStockInfo(stockInfoRequestDto.getTicker());

        return new ResponseEntity(stockInfoResponseDto, HttpStatus.OK);

    }

}