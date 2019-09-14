package cn.lifengming.springexpand;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lifengming
 * @date 2019-07-22 22:58
 */
@Component
public class MyApplicationListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件。。。"+event);
    }
}
