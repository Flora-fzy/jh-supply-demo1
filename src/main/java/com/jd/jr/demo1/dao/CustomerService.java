package com.jd.jr.demo1.dao;

import com.jd.jr.demo1.result.Result;

/**
 * @description: TODO
 * @author fangziyin1
 * @date 2021/6/21 18:13
 * @version 1.0
 */
public interface CustomerService {
    public Result userOrder(String userId, String providerId);
    public Result queryUserOrder(String userId);
}
