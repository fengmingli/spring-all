package com.lifengming.springtomcat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>spring自带String解析器，如果需要解析Map那么需要依赖fastJson来解析
 * 依赖fastJson，并且需要注册进去 {@link com.lifengming.springtomcat.AppConfig,org.springframework.http.converter.HttpMessageConverter}
 * <p/>
 * @author lifengming
 * @since 11.09.2019
 */
@Controller
public class MyController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "lifengming";
    }


    @RequestMapping("/map")
    @ResponseBody
    public Map<String,String> getMap(){
        Map map=new HashMap<String,String>();
        map.put("lfm","lifengming");

        return map;
    }
}
