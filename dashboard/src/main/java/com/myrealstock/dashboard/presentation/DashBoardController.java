package com.myrealstock.dashboard.presentation;

import com.myrealstock.dashboard.application.DashBoardService;
import com.myrealstock.dashboard.domain.SearchStockInfoCrawl;
import com.myrealstock.dashboard.presentation.dto.DetailStockInfoResponseDto;
import com.myrealstock.dashboard.presentation.dto.SimpleStockInfoResponseDto;
import com.myrealstock.dashboard.presentation.dto.UpdateInfoDto;
import com.myrealstock.dashboard.presentation.dto.UserStockInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class DashBoardController {

    private final DashBoardService dashBoardService;

    // 사용자 보유 주식 간략한 정보(대시보드) 화면
    // 주식이름, 수량, 평단가, 현재가, 수익, 수익률
    @GetMapping("/dashboard")
    public List<SimpleStockInfoResponseDto> showDashBoard(@RequestHeader("userId") String userId) {
        List<SimpleStockInfoResponseDto> simpleStockInfoResponseDtoList = dashBoardService.getUserDashBoardStockInfo(userId);
        return simpleStockInfoResponseDtoList;
    }

    // 사용자 보유 주식 상세 정보(포트폴리오) 화면
    @GetMapping("/portfolio")
    public List<DetailStockInfoResponseDto> showPortfolio(@RequestHeader("userId") String userId) {
        List<DetailStockInfoResponseDto> detailStockInfoResponseDtoList = dashBoardService.getUserPortfolioStockInfo(userId);
        return detailStockInfoResponseDtoList;
    }

    // 대시보드 화면에서 종목 추가
    @GetMapping("/dashboard/add")
    public String addStockInfoInDashBoard() {
        return "redirect:/add";
    }

    // 포트폴리오 화면에서 종목 추가
    @GetMapping("/portfolio/add")
    public String addStockInfoInPortfolio() {
        return "redirect:/add";
    }

    // 검색 화면
    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/search/{stockName}")
    public List<SearchStockInfoCrawl> searchStock(@PathVariable("stockName") String stockName) {
        return dashBoardService.searchStockInfo(stockName);
    }

//    @GetMapping("/search/{stockName}")
//    public List<SearchStockInfoCrawl> searchStock2(@PathVariable("stockName") String stockName, @RequestParam("page") Integer page) {
//        return dashBoardService.searchStockInfo(stockName);
//    }

    // 사용자 주식 추가(이름, 수량, 평단) -> db에 저장
    @PostMapping("/add")
    public void saveStockInfo(@RequestBody UserStockInfoDto userStockInfoDto) {
        dashBoardService.saveStockInfo(userStockInfoDto);
    }

    // 관심종목 평단가 및 갯수 수정
    @PostMapping("/dashboard/fix/{stockName}")
    public void updateStockInfo(@PathVariable("stockName") String stockName, @RequestHeader("userId") String userId, @RequestBody UpdateInfoDto updateInfoDto) {
        dashBoardService.updateStockInfo(userId, stockName, updateInfoDto);
    }

}
