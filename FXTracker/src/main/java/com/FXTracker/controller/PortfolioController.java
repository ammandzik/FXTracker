package com.FXTracker.controller;

import com.FXTracker.DTO.PortfolioDto;
import com.FXTracker.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/portfolio")
@RestController
class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/create")
    public ResponseEntity<PortfolioDto> createNewPortfolio(@RequestBody PortfolioDto portfolio) {

        return ResponseEntity.ok(portfolioService.createPortfolio(portfolio));

    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<PortfolioDto> updatePortfolio(@PathVariable String userId, @RequestBody PortfolioDto portfolioDto) {

        return ResponseEntity.ok(portfolioDto);

    }

    @GetMapping("/all")
    public ResponseEntity<List<PortfolioDto>> getAllPortfolios() {

        List<PortfolioDto> portfolioList = portfolioService.getAllPortfolios();

        return ResponseEntity.ok(portfolioList);
    }


}



