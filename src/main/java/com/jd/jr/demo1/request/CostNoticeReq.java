package com.jd.jr.demo1.request;

import java.math.BigDecimal;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: 消费提示：包含订单号，状态，价格，时间
 * @date 2021/6/21 10:12
 */
public class CostNoticeReq extends BaseReq{
    /**
     * 订单号
     */
    private String orderTradeNo;

    /**
     * 订单时间
     */
    private String orderTradeTime;

    /**
     * 订单状态
     */
    private String orderTradeStatus;
    /**
     * 订单交易价格
     */
    private BigDecimal orderMoney;

    private String extInfo;

}
