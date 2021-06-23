package com.jd.jr.demo1.entity;

import lombok.Data;

/**
 * @description: 供应方实体
 * @author fang
 * @date
 * @version 1.0
 */
@Data
public class Provider {
    /**
     * 用户账户id
     */
    private String userAccountId;

    /**
     * 用户账户类型
     *
     */
    private String userAccountType;
}
