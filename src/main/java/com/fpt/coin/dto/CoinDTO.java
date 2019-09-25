package com.fpt.coin.dto;

import com.fpt.coin.entity.Coin;
import com.fpt.coin.util.DateTimeUtil;
import com.fpt.coin.util.ObjectUtil;

public class CoinDTO {

    private int Id;
    private String name;
    private String baseAsset;
    private String quoteAsset;
    private String lastPrice;
    private String volumn24h;
    private String marketName;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String status;

    public CoinDTO() {
    }

    public CoinDTO(Coin coin) {
        ObjectUtil.cloneObject(this, coin);
        this.marketName = coin.getMarket().getName();
        this.lastPrice = String.valueOf(coin.getLastPrice());
        this.volumn24h = String.valueOf(coin.getVolumn24h());
        this.createdAt = DateTimeUtil.formatDateFromLong(coin.getCreatedAt());
        this.updatedAt = DateTimeUtil.formatDateFromLong(coin.getUpdatedAt());
        this.deletedAt = DateTimeUtil.formatDateFromLong(coin.getDeletedAt());
        this.status = coin.getStatus() == 1 ? "Active" : "Deactive";
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getVolumn24h() {
        return volumn24h;
    }

    public void setVolumn24h(String volumn24h) {
        this.volumn24h = volumn24h;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
