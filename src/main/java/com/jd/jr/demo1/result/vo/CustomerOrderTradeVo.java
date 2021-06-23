package com.jd.jr.demo1.result.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 11:32
 */
@Data
public class CustomerOrderTradeVo {
    /**
     * 订单号
     */
    @NotNull(message = "orderTradeNo不能为空")
    private String orderTradeNo;

    /**
     * 兑换码
     */
    private String exchangeCode;

    /**
     * 订单cache <userId,tradeNo>
     */
    private Map<String,String> userTradeCache = new HashMap<>();
    /**
     * 订单cache1 <tradeNo,exchangeCode>
     */
    private Map<String,String> tradeCodeCache = new HashMap<>();


    public String getOrderTradeNo() {
        return orderTradeNo;
    }

    public void setOrderTradeNo(String orderTradeNo) {
        this.orderTradeNo = orderTradeNo;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public Map<String, String> getUserTradeCache() {
        return userTradeCache;
    }

    public void setUserTradeCache(Map<String, String> userTradeCache) {
        this.userTradeCache = userTradeCache;
    }

    public Map<String, String> getTradeCodeCache() {
        return tradeCodeCache;
    }

    public void setTradeCodeCache(Map<String, String> tradeCodeCache) {
        this.tradeCodeCache = tradeCodeCache;
    }
}
