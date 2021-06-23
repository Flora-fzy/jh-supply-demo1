package com.jd.jr.demo1.request;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: 采购方下单请求
 * @date 2021/6/21 10:24
 */
@Data
public class CustomerOrderTradeReq extends BaseReq{

    /**
     * 用户账号ID
     */
    @NotNull(message = "userAccountId不能为空")
    private String userAccountId;

    /**
     * 用户账号类型
     */
    @NotNull(message = "userAccountType不能为空")
    private String userAccountType;

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
public String getUserAccountId() {
    return userAccountId;
}

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }
}
