package com.jd.jr.demo1.service;

import com.jd.jr.demo1.dao.ProviderService;
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
 * @date 2021/6/21 17:37
 */

public class ProviderServiceImpl implements ProviderService {
    /**
     * 订单cache <userId,tradeNo>
     */
    private  Map<String,String> userTradeCache;
    /**
     * 订单cache1 <tradeNo,exchangeCode>
     */
    private  Map<String,String> tradeCodeCache;

    @Override
    public Result<ProviderOrderTradeVo> providerOrder(String providerId, String tradeNo){
        ProviderOrderTradeVo vo = new ProviderOrderTradeVo();
        {
            if(StringUtils.isEmpty(providerId)){
                Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.SYSTEM_PARAM_ERROR.code(),"userAccountId为空");
                return r;
            }
            if(StringUtils.isEmpty(tradeNo)){
                Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.SYSTEM_PARAM_ERROR.code(),"订单号为空");
                return r;
            }
            userTradeCache = vo.getUserTradeCache();
            tradeCodeCache = vo.getTradeCodeCache();

            userTradeCache.put(providerId, tradeNo);
            //生成兑换码
            long code = (long) (Math.random()*1000000);
            vo.setExchangeCode(String.valueOf(code));
            tradeCodeCache.put(tradeNo,vo.getExchangeCode());

            Result<ProviderOrderTradeVo> r = Result.getSuccessResultVo();
            r.setData(vo);
            r.setTradeCodeCache(tradeCodeCache);
            r.setUserTradeCache(userTradeCache);

            return r;
        }
    }

    @Override
    public Result queryProviderOrder(String providerId) {
        ProviderOrderTradeVo vo = new ProviderOrderTradeVo();
        if (StringUtils.isEmpty(providerId)) {
            Result<ProviderOrderTradeVo> r =
                    Result.getResult(ResultCodeEnum.SYSTEM_PARAM_ERROR.code(), "providerAccountId为空");
            return r;
        }
        if(userTradeCache.containsKey(providerId)){
            vo.setOrderTradeNo(userTradeCache.get(providerId));
            if(tradeCodeCache.containsKey(vo.getOrderTradeNo())){
                vo.setExchangeCode(tradeCodeCache.get(vo.getOrderTradeNo()));
            }else{
                Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.BIZ_POINT_REFUND_NO_ORIGINAL.code(),"订单号为空");
                return r;
            }
        }else{
            Result<ProviderOrderTradeVo> r = Result.getResult(ResultCodeEnum.SYSTEM_RESULT_NULL,"该用户无订单");
            return r;
        }
        Result<ProviderOrderTradeVo> r = Result.getSuccessResultVo();
        r.setData(vo);
        r.setTradeCodeCache(tradeCodeCache);
        r.setUserTradeCache(userTradeCache);

        return r;
    }
}
