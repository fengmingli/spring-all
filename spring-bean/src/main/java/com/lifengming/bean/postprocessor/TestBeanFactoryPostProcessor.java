package com.lifengming.bean.postprocessor;

import com.lifengming.bean.service.UserOneService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * com.lifengming.bean.service.UserOneService#userTwoService
 * 不使用@Autowired注入
 * 通过userOneService.setAutowireMode(2); 设置自动装配模型也可以注入
 * <p>
 *@Autowired也是手动注入方式
 * @author lifengming
 * @since 2019.11.24
 */
@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition userOneService = (GenericBeanDefinition) beanFactory.getBeanDefinition("userOneService");
//      设置userOneService的注入模型（2-byType）
        userOneService.setAutowireMode(2);

        System.out.println(userOneService.getAutowireMode());
    }
}
