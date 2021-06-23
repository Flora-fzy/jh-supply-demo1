package com.jd.jr.demo1.controller;

import com.jd.jr.demo1.dao.ProviderService;
import com.jd.jr.demo1.request.CustomerOrderTradeReq;
import com.jd.jr.demo1.request.ProviderOrderTradeReq;
import com.jd.jr.demo1.result.Result;
import com.jd.jr.demo1.result.ResultCodeEnum;
import com.jd.jr.demo1.result.vo.CustomerOrderTradeVo;
import com.jd.jr.demo1.result.vo.ProviderOrderTradeVo;
import com.jd.jr.demo1.service.CustomerServiceImpl;
import com.jd.jr.demo1.service.ProviderServiceImpl;
import com.jd.jr.demo1.util.JacksonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: 供应链-下单demo
 * @date 2021/6/21 11:08
 */
@RestController("/")
public class OrderTradeController {

    /**
     * 订单cache <userId,tradeNo>
     */
    private Map<String,String> userTradeCache = new HashMap<>();
    /**
     * 订单cache1 <tradeNo,exchangeCode>
     */
    private Map<String,String> tradeCodeCache = new HashMap<>();
    /**
     * 订单号
     */
    private String tempOrderNo;

    @RequestMapping("/index")
    public String hello(){
        return "hello";
    }
    /**
     * 采购方下单
     * (1)生成订单号
     * (2)获得兑换码
     * (3)返回结果
     */

    @RequestMapping("user/order")
    public String userOrder(@RequestBody CustomerOrderTradeReq reqc,@RequestBody ProviderOrderTradeReq reqp){
        CustomerServiceImpl cs = new CustomerServiceImpl();
        Result<CustomerOrderTradeVo> rc = cs.userOrder(reqc.getUserAccountId(),reqp.getProviderAccountId());
        return JacksonUtil.pojo2Json(rc);

    }

    /**
     * 采购方订单查询
     * (1)获取id
     * (2)查询map，获得所有订单号
     * (3)
     */
    @PostMapping("user/query")
    public String queryUserOrder(@RequestBody CustomerOrderTradeReq req){
        CustomerServiceImpl cs = new CustomerServiceImpl();
        Result<CustomerOrderTradeVo> rc = cs.queryUserOrder(req.getUserAccountId());
        return JacksonUtil.pojo2Json(rc);
    }

    /**
     * 供应方订单查询
     * (1)获取供应商id
     * (2)查订单号
     * (3)查兑换码
     */
    @RequestMapping("provider/query")
    public String queryProviderOrder(@RequestBody ProviderOrderTradeReq req){
        ProviderServiceImpl ps = new ProviderServiceImpl();
        Result<ProviderOrderTradeVo> rp = ps.queryProviderOrder(req.getProviderAccountId());
        return JacksonUtil.pojo2Json(rp);
    }
}
