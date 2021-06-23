package com.jd.jr.demo1.dao;

import com.jd.jr.demo1.result.Result;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 18:20
 */
public interface ProviderService {
    public Result providerOrder(String providerId,String TradeNo);
    public Result queryProviderOrder(String providerId);
}
