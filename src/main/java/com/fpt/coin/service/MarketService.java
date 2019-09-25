package com.fpt.coin.service;

import com.fpt.coin.dto.MarketDTO;
import com.fpt.coin.entity.Market;
import com.fpt.coin.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MarketService {
    @Autowired
    MarketRepository marketRepository;

    public Market create(Market market) {

        return marketRepository.save(market);
    }

    public List<MarketDTO> getList() {
        List<Market> markets =  marketRepository.findAll();
        List<MarketDTO> coinDTOS = new ArrayList<>();
        for (Market market : markets
        ) {
            coinDTOS.add(new MarketDTO(market));
        }
        return coinDTOS;
    }
}
