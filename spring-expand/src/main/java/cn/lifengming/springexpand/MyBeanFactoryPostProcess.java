package cn.lifengming.springexpand;

import cn.lifengming.spring.common.Apple;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * @author lifengming
 * @date 2019-07-22 21:52
 */
@Component
public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcess ...");
        int count = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前bean中有" + count + "个bean被加载了。。。");
        System.out.println(Arrays.asList(beanDefinitionNames));


        Map<String, Apple> map = beanFactory.getBeansOfType(Apple.class);
        for (Apple apple : map.values()) {
                assert apple.getClass()==null;
        }
    }
}
