package com.fpt.coin.controller;

import com.fpt.coin.dto.CoinDTO;
import com.fpt.coin.entity.Coin;
import com.fpt.coin.entity.rest.RESTResponse;
import com.fpt.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin()
@RestController
@RequestMapping(value = "/api/v1/coin")
public class CoinController {
    @Autowired
    CoinService coinService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam(value = "nameSearch", required = false) String nameSearch
            ,@RequestParam(defaultValue = "-1", required = false) int marketId){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setMessage("List")
                .setStatus(1)
                .addDatas(coinService.getList(nameSearch,marketId))
                .build(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/{id}")
    public ResponseEntity<Object> store(@RequestBody Coin coin,@PathVariable int id) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Action Success")
                .addData(new CoinDTO(coinService.create(coin,id)))
                .build(),
                HttpStatus.CREATED);
    }
}
