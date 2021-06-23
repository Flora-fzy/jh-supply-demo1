package com.jd.jr.demo1.result;

/**
 * @author  fangziyin1
 * @version 1.0
 * @date
 * @description result枚举值
 * 枚举定义规范：
 *   (1)两个特殊枚举：1 代表成功；9999代表系统异常；
 *   (2)其它枚举值均以7开头，为7xxx四位格式;
 *   (3)注意(不看会踩坑)：新增枚举值，只能在末尾顺延，不能在中间插入，不然会踩坑（跟JSF默认序列化方式有关系)；
 */
public enum ResultCodeEnum {
    SUCCESS(1, "成功"),
    SYSTEM_ERROR(9999, "系统异常"),
    SYSTEM_RESULT_NULL(7000,"结果为null"),
    SYSTEM_PARAM_ERROR(7001,"参数输入有误"),
    SYSTEM_MSG_UNMATCH(7005,"消息体不匹配"),
    BIZ_CUSTOM_ERROR(7100,"未知原因"),
    BIZ_POINT_REFUND_NO_ORIGINAL(7105,"原单号不存在")
            ;

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
