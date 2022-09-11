package com.myrealstock.portfolio.feign;

import com.myrealstock.portfolio.configure.FeignConfig;
import com.myrealstock.portfolio.presentation.StockInfoRequestDto;
import com.myrealstock.portfolio.presentation.StockInfoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * FeignClient.url = StockInfo 서비스의 url
 *
 * Feign은 url + value(uri)값으로 요청했을 때 반환받은 Json을 메소드 타입과 매핑해서 세팅해 줌
 *
 */
@FeignClient(name = "test", url="http://localhost:8080", configuration = {FeignConfig.class})
public interface StockInfoInterface {

    @RequestMapping(method = RequestMethod.GET, value ="/api/stock/find")
    StockInfoResponseDto getStockInfo(@RequestBody StockInfoRequestDto stockInfoRequestDto);

}