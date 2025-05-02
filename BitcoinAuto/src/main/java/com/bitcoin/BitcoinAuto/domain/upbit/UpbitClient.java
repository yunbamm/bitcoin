package com.bitcoin.BitcoinAuto.domain.upbit;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class UpbitClient {
    private final WebClient webClient = WebClient.create("https://api.upbit.com");

    public List<Candle> getMinCandles(String market, int count, int minuteUnit) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/candles/minutes/" + minuteUnit)
                        .queryParam("market", market)
                        .queryParam("count", count)
                        .build())
                .retrieve()
                .bodyToFlux(Candle.class)
                .collectList()
                .block();
    }
}