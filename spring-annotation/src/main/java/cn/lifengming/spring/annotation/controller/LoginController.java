package cn.lifengming.spring.annotation.controller;

import cn.lifengming.spring.annotation.annnotation.PermissionLimit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lifengming
 * @since 09.09.2019
 */
@Controller
@RequestMapping("/anno")
public class LoginController {

    @GetMapping("/test")
    @PermissionLimit
    public void testAnnotation(){
        System.out.println("方法内部！！！");
    }

    @GetMapping("/test1")
    public void testAnnotation1(){
        System.out.println("方法内部===111！！！");
    }

}
