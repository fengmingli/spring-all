package com.lifengming.bean;

import com.lifengming.bean.config.BeanConfig;
import com.lifengming.bean.service.UserOneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean
 * @author lifengming
 * @since 2019.11.24
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        applicationContext.getBean(UserOneService.class).getService();
//        applicationContext.stop();
    }


}
