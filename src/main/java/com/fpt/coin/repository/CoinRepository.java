package com.fpt.coin.repository;

import com.fpt.coin.entity.Coin;
import com.fpt.coin.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoinRepository  extends JpaRepository<Coin, Integer>{
    @Query("select c from Coin as c where c.name = :key")
    List<Coin> findWithSearchName(@Param("keySearch") String key);
    List<Coin> findAllByMarketEquals(Market market);
}
