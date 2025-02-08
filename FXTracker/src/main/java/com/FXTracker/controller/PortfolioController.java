package com.FXTracker.controller;

import com.FXTracker.DTO.PortfolioDto;
import com.FXTracker.model.Portfolio;
import com.FXTracker.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/{id}")
    public ResponseEntity updatePortfolio(@PathVariable String id, @RequestBody PortfolioDto portfolioDto) {

        return ResponseEntity.ok(HttpStatus.OK);

    }


}



