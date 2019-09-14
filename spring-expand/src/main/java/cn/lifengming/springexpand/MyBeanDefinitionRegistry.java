package cn.lifengming.springexpand;

import cn.lifengming.springexpand.mybean.People;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lifengming
 * @since 10.09.2019
 */
public class MyBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(People.class);
//        AbstractBeanDefinition beanDefinition =beanDefinitionBuilder.getBeanDefinition();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(People.class).getBeanDefinition();
        registry.registerBeanDefinition("lfm",beanDefinition);


//        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.rootBeanDefinition(People.class).getBeanDefinition();
    }
}
