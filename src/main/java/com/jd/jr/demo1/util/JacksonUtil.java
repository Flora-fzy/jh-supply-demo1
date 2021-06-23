package com.jd.jr.demo1.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author fangziyin1
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 14:03
 */
public class JacksonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * pojo转json
     *
     * @param obj pojo
     * @return json字符串
     */
    public static String pojo2Json(Object obj) {
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
