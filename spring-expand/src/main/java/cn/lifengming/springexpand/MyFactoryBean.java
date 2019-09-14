package cn.lifengming.springexpand;

import cn.lifengming.springexpand.mybean.Dog;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lifengming
 * @since 10.09.2019
 */
public class MyFactoryBean implements FactoryBean {

    public Object getObject() throws Exception {
        return  new Dog();
    }

    public Class<?> getObjectType() {
        return Dog.class;
    }
}
