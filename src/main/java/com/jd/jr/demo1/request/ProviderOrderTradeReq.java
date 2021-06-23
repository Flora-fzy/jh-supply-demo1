package com.jd.jr.demo1.request;

import javax.validation.constraints.NotNull;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: 供应方生成订单请求
 * @date 2021/6/21 10:36
 */
public class ProviderOrderTradeReq extends BaseReq{
    /**
     * 用户账号ID
     */
    @NotNull(message = "providerAccountId不能为空")
    private String providerAccountId;

    /**
     * 用户账号类型
     */
    @NotNull(message = "providerAccountType不能为空")
    private String providerAccountType;

//    /**
//     * 订单号
//     */
//    @NotNull(message = "orderTradeNo不能为空")
//    private String orderTradeNo;
//
//    /**
//     * 兑换码
//     */
//    private String exchangeCode;

    public String getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(String providerAccountId) {
        this.providerAccountId = providerAccountId;
    }

    public String getProviderAccountType() {
        return providerAccountType;
    }

    public void setProviderAccountType(String providerAccountType) {
        this.providerAccountType = providerAccountType;
    }
}
