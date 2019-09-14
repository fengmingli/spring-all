package cn.lifengming.springexpand;

import cn.lifengming.spring.common.Apple;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistry Bean定义信息的存储中心，以后BeanFactory就是按照BeanDefinitionRegistry 里面保存的每一个bean信息创建bean实例的
 *
 * @author lifengming
 * @date 2019-07-22 22:28
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry...bean的数量" + registry.getBeanDefinitionCount());
       // RootBeanDefinition beanDefinition = new RootBeanDefinition(Apple.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Apple.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", beanDefinition);
    }


    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory...bean的数量" + beanFactory.getBeanDefinitionCount());
    }
}
