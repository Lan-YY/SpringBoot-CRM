package com.thymeleaf.mybatis.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Package: com.thymeleaf.mybatis.mapper
 * <p>
 * Author: 懒洋洋
 * <p>
 * Date: Created in 2020/1/9 16:50
 */
public class MyObjectMapper extends ObjectMapper {
    private static  final long serialVersionUID =1L;

    public MyObjectMapper(){
        super();
        // 去掉各种@jsonSerializa 注解的解析
        // this.configure(MapperFeature.USE_ANNOTATIONS,false);
        //  针对非空的值进行序列化
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 将类型序列化到属性JSON字符串中
        this.enableDefaultTyping(DefaultTyping.NON_FINAL,JsonTypeInfo.As.PROPERTY);
        // 对于找不到匹配属性的时候忽略报错
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        // 不包含任何属性的 bean 也不报错
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
    }
}


