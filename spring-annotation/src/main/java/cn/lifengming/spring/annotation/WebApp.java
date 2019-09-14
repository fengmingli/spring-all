package cn.lifengming.spring.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lifengming
 * @since 09.09.2019
 */
@SpringBootApplication
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class,args);
        System.out.println("启动成功！");
    }
}
