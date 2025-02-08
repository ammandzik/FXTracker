package com.FXTracker.service;

import com.FXTracker.DTO.StockDto;
import com.FXTracker.exception.StockNotFoundException;
import com.FXTracker.exception.StockServiceException;
import com.FXTracker.mapper.StockMapper;
import com.FXTracker.model.Stock;
import com.FXTracker.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockService {

    private final StockMapper stockMapper;
    private final StockRepository stockRepository;

    public StockDto addStock(StockDto stockDto) {

        try {
            stockRepository.save(stockMapper.toStock(stockDto));

        } catch (Exception ex) {
            throw new StockServiceException("Error occurred while saving a stock.");
        }
        return stockDto;
    }

    public StockDto getStock(String symbol) {

        Optional<Stock> stock = stockRepository.findStockBySymbol(symbol);

        if (stock.isEmpty()) {
            throw new StockNotFoundException(String.format("Stock was not found with given symbol: %s", symbol));

        } else {
            return stockMapper.toDto(stock.get());

        }
    }

    public StockDto updateStock(String symbol, StockDto stock) {

        var updated = getStock(symbol);

        try {

            stock.setId(updated.getId());

        } catch (Exception ex) {

            throw new StockServiceException("Error occurred while updating a stock.");
        }

        stockRepository.save(stockMapper.toStock(stock));

        return stock;
    }

    public List<StockDto> findAllStocks() {

        List<Stock> stocks = stockRepository.findAll();

        if (stocks.isEmpty()) {
            throw new StockNotFoundException("No stocks were found.");
        }

        return stocks.stream()
                .map(stockMapper::toDto)
                .collect(toList());
    }

    public boolean stockExistsInDataBase(String symbol) {

        return stockRepository.existsBySymbol(symbol);
    }
}
