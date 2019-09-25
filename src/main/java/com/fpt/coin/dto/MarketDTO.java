package com.fpt.coin.dto;

import com.fpt.coin.entity.Market;
import com.fpt.coin.util.DateTimeUtil;
import com.fpt.coin.util.ObjectUtil;

public class MarketDTO
{
    private int Id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String status;

    public MarketDTO() {
    }

    public MarketDTO(Market market) {
        ObjectUtil.cloneObject(this, market);
        this.createdAt = DateTimeUtil.formatDateFromLong(market.getCreatedAt());
        this.updatedAt = DateTimeUtil.formatDateFromLong(market.getUpdatedAt());
        this.deletedAt = DateTimeUtil.formatDateFromLong(market.getDeletedAt());
        this.status = market.getStatus() == 1 ? "Active" : "Deactive";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
