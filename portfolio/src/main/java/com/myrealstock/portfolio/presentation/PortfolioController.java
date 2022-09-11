package com.myrealstock.portfolio.presentation;

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
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService portfolioService;

//    // 포트폴리오에 주식 추가
//    @RequestMapping(method = RequestMethod.POST, value = "/add")
////    @RequestMapping(method = RequestMethod.POST, value = "/portfolio/{portfolioName}/add")
//    ResponseEntity<StockInfoResponseDto> addStock(@RequestBody StockInfoRequestDto stockInfoRequestDto) {
//
//        StockInfoResponseDto result = portfolioService.getStockInfo(stockInfoRequestDto);
//
//        return new ResponseEntity(result, HttpStatus.OK);
//    }

    // 포트폴리오 생성
    @RequestMapping(method = RequestMethod.POST, value = "/portfolio")
    ResponseEntity generatePortfolio(@RequestBody GeneratePortfolioRequestDto generatePortfolioRequestDto) {

        portfolioService.generatePortfolio(generatePortfolioRequestDto);

        return new ResponseEntity("success", HttpStatus.OK);
    }

}
