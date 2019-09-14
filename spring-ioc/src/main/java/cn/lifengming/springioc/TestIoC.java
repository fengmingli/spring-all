package cn.lifengming.springioc;

/**
 * @author lifengming
 * @since 15.08.2019
 */
public class TestIoC {

    public static void main(String[] args) {
        new TestIoC().testIoC();
    }

    public void testIoC() {
        // 1. 创建beanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注册bean
        BeanDefinition bd = new BeanDefinition();
        bd.setBeanClassName("cn.lifengming.spring.ioc.HelloWorld");

        BeanDefinitionHolder bdh = new BeanDefinitionHolder("helloWorld", bd);
        beanFactory.registerBeanDefinition(bdh.getBeanName(), bdh.getBeanDefinition());

        // 3. 获取bean
        HelloWorld hello = (HelloWorld) beanFactory.getBean("helloWorld");

        System.out.println("Hello World!"+ hello.sayHello());
    }

    public void testIoCProperty() {
        // 1. 创建beanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注册bean
        BeanDefinition bd = new BeanDefinition();
        bd.setBeanClassName("cn.lifengming.spring.ioc.HelloWorld");

        // 注入Property
        PropertyValues pvs = new PropertyValues();
        pvs.addPropertyValue(new PropertyValue("msg", "Hello IoC Property!"));
        bd.setPropertyValues(pvs);

        BeanDefinitionHolder bdh = new BeanDefinitionHolder("helloWorld", bd);
        beanFactory.registerBeanDefinition(bdh.getBeanName(), bdh.getBeanDefinition());

        // 3. 获取bean
        HelloWorld hello = (HelloWorld) beanFactory.getBean("helloWorld");
        System.out.println("Hello IoC Property!"+hello.sayHello());
    }
}
