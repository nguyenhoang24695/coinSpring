package com.fpt.coin.service;

import com.fpt.coin.dto.CoinDTO;
import com.fpt.coin.entity.Coin;
import com.fpt.coin.entity.Market;
import com.fpt.coin.repository.CoinRepository;
import com.fpt.coin.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
public class CoinService {
@Autowired
    CoinRepository coinRepository;
@Autowired
    MarketRepository marketRepository;
    public List<CoinDTO> getList(String nameSearch,int marketId) {
        List<Coin> coins = null;
        if (nameSearch != null && !nameSearch.isEmpty()){
            coins =  coinRepository.findWithSearchName(nameSearch);
        }else if(marketId != -1){
            Market market = marketRepository.findById(marketId).orElse(null);
            if (market == null){
                return null;
            }
            coins = coinRepository.findAllByMarketEquals(market);
        }
        else {
            coins =  coinRepository.findAll();
        }

        List<CoinDTO> coinDTOS = new ArrayList<>();
        for (Coin coin : coins
             ) {
            coinDTOS.add(new CoinDTO(coin));
        }
        return coinDTOS;
    }
    public Coin create(Coin coin,int MarketId){
        Market market = marketRepository.findById(MarketId).orElse(null);
        if (market == null){
            return null;
        }
        coin.setMarket(market);
        market.addCoin(coin);
        coinRepository.save(coin);
        marketRepository.save(market);
        return coin;
    }
}
