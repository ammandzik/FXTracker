package com.FXTracker;

import com.FXTracker.DTO.PortfolioDto;
import com.FXTracker.DTO.StockDto;
import com.FXTracker.model.User;

import java.util.HashMap;

public class DataTest {

    public static User createUser() {

        return User.builder()
                .name("Ola")
                .surname("Fasola")
                .email("ola221@gmail.com")
                .password("Puszolinda23422")
                .build();
    }

    public static StockDto createStock() {

        return StockDto.builder()
                .id(null)
                .symbol("TTWO")
                .price("185.60")
                .changePercent("0.66")
                .build();
    }

    public static PortfolioDto testPortfolio(HashMap<String, String> stocks) {

        return PortfolioDto.builder()
                .userId(DataTest.createUser().getId())
                .stocks(stocks)
                .balance(1500F)
                .profit(300F)
                .loss(0F)
                .build();
    }
}
