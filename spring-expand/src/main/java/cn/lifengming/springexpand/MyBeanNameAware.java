package cn.lifengming.springexpand;

import cn.lifengming.spring.common.Apple;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @since 26.07.2019
 */
@Component
public class MyBeanNameAware implements ApplicationContextAware  {


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Apple apple=(Apple)applicationContext.getBean("apple");
        System.out.println("lifengming123==="+apple);
    }
}
