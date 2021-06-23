package com.jd.jr.demo1.service;

import com.jd.jr.demo1.dao.CustomerService;
import com.jd.jr.demo1.dao.ProviderService;
import com.jd.jr.demo1.request.CustomerOrderTradeReq;
import com.jd.jr.demo1.request.ProviderOrderTradeReq;
import com.jd.jr.demo1.result.Result;
import com.jd.jr.demo1.result.ResultCodeEnum;
import com.jd.jr.demo1.result.vo.CustomerOrderTradeVo;
import com.jd.jr.demo1.result.vo.ProviderOrderTradeVo;
import com.jd.jr.demo1.util.JacksonUtil;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 11:04
 */
public class CustomerServiceImpl implements CustomerService {
  /** 订单cache <userId,tradeNo> */
  private Map<String, String> userTradeCache;
  /** 订单cache1 <tradeNo,exchangeCode> */
  private Map<String, String> tradeCodeCache;

  /** 采购方下单 (1)生成订单号 (2)获得兑换码 (3)返回结果 */
  @Override
  public Result<CustomerOrderTradeVo> userOrder(String userId, String providerId) {
    CustomerOrderTradeVo vo = new CustomerOrderTradeVo();
    if (StringUtils.isEmpty(userId)) {
      Result<CustomerOrderTradeVo> r =
          Result.getResult(ResultCodeEnum.SYSTEM_PARAM_ERROR.code(), "userAccountId为空");
      return r;
    }

    userTradeCache = vo.getUserTradeCache();
    tradeCodeCache = vo.getTradeCodeCache();
    // 采购方的订单号（江湖生成的）
    long num = (long) (Math.random() * (9999999999999L - 1000000000000L)) + 1000000000000L;

    userTradeCache.put(userId, String.valueOf(num));

    vo.setOrderTradeNo(String.valueOf(num));
    // tempOrderNo = vo.getOrderTradeNo();

    // 调用供应商下单接口
    Result<ProviderOrderTradeVo> rp =
        new ProviderServiceImpl().providerOrder(userId, vo.getOrderTradeNo());

    tradeCodeCache.put(vo.getOrderTradeNo(),rp.getData().getExchangeCode());
    vo.setExchangeCode(rp.getData().getExchangeCode());

    Result<CustomerOrderTradeVo> r = Result.getSuccessResultVo();
    r.setData(vo);
    r.setUserTradeCache(userTradeCache);
    r.setTradeCodeCache(tradeCodeCache);
    return r;
  }

  @Override
  public Result<CustomerOrderTradeVo> queryUserOrder(String userId) {
    CustomerOrderTradeVo vo = new CustomerOrderTradeVo();
    if(StringUtils.isEmpty(userId)){
      Result<CustomerOrderTradeVo> r =
              Result.getResult(ResultCodeEnum.SYSTEM_PARAM_ERROR.code(), "userAccountId为空");
      return r;
    }
    if(userTradeCache.containsKey(userId)){
      vo.setOrderTradeNo(userTradeCache.get(userId));
      if(tradeCodeCache.containsKey(vo.getOrderTradeNo())){
        vo.setExchangeCode(tradeCodeCache.get(vo.getOrderTradeNo()));
      }else{
        Result<CustomerOrderTradeVo> r = Result.getResult(ResultCodeEnum.BIZ_POINT_REFUND_NO_ORIGINAL.code(),"订单号为空");
        return r;
      }
    }else{
      Result<CustomerOrderTradeVo> r = Result.getResult(ResultCodeEnum.SYSTEM_RESULT_NULL.code(), "该用户无订单");
      return r;
    }
    Result<CustomerOrderTradeVo> r = Result.getSuccessResultVo();
    r.setData(vo);
    r.setUserTradeCache(userTradeCache);
    r.setTradeCodeCache(tradeCodeCache);
    return r;
  }
}
