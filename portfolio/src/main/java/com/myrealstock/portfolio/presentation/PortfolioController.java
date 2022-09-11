package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.application.FeignStockInfoService;
import com.myrealstock.portfolio.application.PortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final FeignStockInfoService feignStockInfoService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    ResponseEntity<StockInfoResponseDto> addStock(@RequestBody StockInfoRequestDto stockInfoRequestDto) {

        StockInfoResponseDto result = feignStockInfoService.getStockInfo(stockInfoRequestDto.getTicker());

        return new ResponseEntity(result, HttpStatus.OK);
    }

}
