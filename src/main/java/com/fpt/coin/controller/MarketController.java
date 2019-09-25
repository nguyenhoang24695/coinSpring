package com.fpt.coin.controller;

import com.fpt.coin.entity.Coin;
import com.fpt.coin.entity.Market;
import com.fpt.coin.entity.rest.RESTResponse;
import com.fpt.coin.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/market")
public class MarketController {
@Autowired
    MarketService marketService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setMessage("List")
                .setStatus(1)
                .addDatas(marketService.getList())
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Market market) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Action Success")
                .addData(marketService.create(market))
                .build(),
                HttpStatus.CREATED);
    }
}
