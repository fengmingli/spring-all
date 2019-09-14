package cn.lifengming.springexpand;

import cn.lifengming.springexpand.mybean.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lifengming
 * @date 2019-07-22 21:58
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnableBeanDefinition.class);
        System.out.println("==========");
//        People lfm=(People) context.getBean("lfm");
//        lfm.setAge(24);
//        lfm.setName("lifengimng");
//        System.out.println(lfm.getAge()+"=="+lfm.getName());
        Object o=context.getBean("MyFactoryBean");
        System.out.println(o);


    }
}
