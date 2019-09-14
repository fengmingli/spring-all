package cn.lifengming.springioc;

/**
 * @author lifengming
 * @since 15.08.2019
 */
public class BeanDefinitionHolder {

    private final BeanDefinition beanDefinition;
    private final String beanName;

    public BeanDefinitionHolder(String beanName, BeanDefinition beanDefinition) {
        this.beanName = beanName;
        this.beanDefinition = beanDefinition;
    }

    public BeanDefinition getBeanDefinition() {
        return this.beanDefinition;
    }

    public String getBeanName() {
        return this.beanName;
    }
}
