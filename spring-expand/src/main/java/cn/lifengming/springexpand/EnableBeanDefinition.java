package cn.lifengming.springexpand;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



/**
 * @author lifengming
 * @since 10.09.2019
 */
@Configuration
@Import(MyFactoryBean.class)
public class EnableBeanDefinition {
}
