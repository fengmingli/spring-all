package cn.lifenming.springxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lifengming
 * @since 24.08.2019
 */
public class QuickRunXml {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        MessageServiceImpl messageService = (MessageServiceImpl) applicationContext.getBean("MessageService");
        System.out.println(messageService.getMessage());
    }
}
