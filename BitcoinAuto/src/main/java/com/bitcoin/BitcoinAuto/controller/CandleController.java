package com.bitcoin.BitcoinAuto.controller;

import com.bitcoin.BitcoinAuto.domain.upbit.Candle;
import com.bitcoin.BitcoinAuto.domain.upbit.UpbitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CandleController {
    private final UpbitClient upbitClient;


    @GetMapping("/candles")
    public List<Candle> getCandles(@RequestParam String market, @RequestParam int count, @RequestParam int minuteUnit) {
        return upbitClient.getMinCandles(market, count, minuteUnit);
    }
}