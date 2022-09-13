package com.myrealstock.portfolio.presentation;

import com.myrealstock.portfolio.application.PortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService portfolioService;

    // 포트폴리오 생성
    @RequestMapping(method = RequestMethod.POST, value = "/portfolio")
    ResponseEntity generatePortfolio(@RequestBody GeneratePortfolioRequestDto generatePortfolioRequestDto,
                                     @RequestHeader(value="USER-TOKEN") String userToken) {

        GeneratePortfolioResponseDto result = portfolioService.generatePortfolio(userToken, generatePortfolioRequestDto);

        return new ResponseEntity(result, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/portfolio")
    ResponseEntity getPortfolioList(@RequestHeader(value="USER-TOKEN") String userToken) {

        List<String> result = portfolioService.getPortfolioInfoList(userToken);

        return new ResponseEntity(result, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/portfolio/extend")
    ResponseEntity extendStock(@RequestBody ExtendStockRequestDto extendStockRequestDto,
                               @RequestHeader(value="USER-TOKEN") String userToken) {

        ExtendStockResponseDto extendStockResponseDto = portfolioService.extendStock(userToken, extendStockRequestDto);

        return new ResponseEntity(extendStockResponseDto, HttpStatus.OK);

    }




}
