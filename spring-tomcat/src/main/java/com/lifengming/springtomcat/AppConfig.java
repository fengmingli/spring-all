package com.lifengming.springtomcat;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author lifengming
 * @since 11.09.2019
 */
@Configurable
@ComponentScan("com.lifengming.springtomcat")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //添加解析map的解析器
        converters.add(new FastJsonHttpMessageConverter());
    }

}
