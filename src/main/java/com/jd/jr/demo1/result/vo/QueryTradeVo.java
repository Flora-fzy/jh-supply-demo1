package com.jd.jr.demo1.result.vo;
/**
 * @description: 采购方订单查询-显示层对象
 * @author fangziyin1
 * @date 2021/6/21 10:04
 * @version 1.0
 */
public class QueryTradeVo {
    /**
     * 订单号
     */
    private String orderTradeNo;

    /**
     * 交易状态(-1:失败  1:成功  0:进行中 2:交易不存在)
     */
    private Integer orderTradeStatus;

    /**
     * 交易时间
     */
    private Long orderTradeTime;

    /**
     *兑换码
     */
    private String exchangeCode;
}
