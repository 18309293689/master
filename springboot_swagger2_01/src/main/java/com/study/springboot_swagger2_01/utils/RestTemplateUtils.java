package com.study.springboot_swagger2_01.utils;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * <p>
 * 用RestTemplate便捷调用http接口的工具类
 * </p>
 *
 * @author 刘嘉淋
 * @since 2021/04/10
 */
@Component
public class RestTemplateUtils {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * <p>
     * 使用exchange发送url不带参数的get请求
     * </p>
     * @param url：不带参数的请求地址
     * @return string
     * @author 刘嘉淋
     * @since 2021/04/10
     */
    public String  getNoParam(String url){
        //创建http请求头
        HttpHeaders headers = new HttpHeaders();
        //设置请求头的媒体类型：以json形式提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        //请求头部body携带json数据(此处不需要)
        JSONObject jsonObj = new JSONObject();
        //请求实体:封装请求头，请求内容
        HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);

        //调用restTemplate的exchange获取响应（参数分别表示请求地址、请求类型、请求实体、响应类型）
        ResponseEntity<String> exchange = restTemplate.exchange(url,
                HttpMethod.GET, entity, String.class);
        return exchange.getBody();
    }

    /**
     * <p>
     * 使用exchange发送url带参数的get请求
     * </p>
     * @param url：带参数的请求地址；map:封装url中参数变量值
     * @return string
     * @author 刘嘉淋
     * @since 2021/04/10
     */
    public String  getParam(String url, Map map){
        //创建http请求头
        HttpHeaders headers = new HttpHeaders();
        //设置请求头的媒体类型：以json形式提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        //请求头部body携带json数据
        JSONObject jsonObj = new JSONObject();
        //请求实体:封装请求头，请求内容
        HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);

        //调用restTemplate的exchange获取响应（参数分别表示请求地址、请求类型、请求实体、响应类型、url中参数变量值）
        ResponseEntity<String> exchange = restTemplate.exchange(url,
                HttpMethod.GET, entity, String.class,map);
        return exchange.getBody();
    }

    /**
     * <p>
     * 使用exchange发送url带参数的post请求
     * </p>
     * @param url：不带参数的请求地址；jsonObj:里面封装请求需要的参数
     * @return string
     * @author 刘嘉淋
     * @since 2021/04/10
     */
    public String  postParam(String url, JSONObject jsonObj){
        //创建http请求头
        HttpHeaders headers = new HttpHeaders();
        //设置请求头的媒体类型：以json形式提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        //请求头部body携带json数据
        //请求实体:封装请求头，请求内容
        HttpEntity<String> entity = new HttpEntity<>(jsonObj.toString(), headers);

        //调用restTemplate的exchange获取响应（参数分别表示请求地址、请求类型、请求实体、响应类型、url中参数变量值）
        ResponseEntity<String> exchange = restTemplate.exchange(url,
                HttpMethod.POST, entity, String.class);
        return exchange.getBody();
    }
}
