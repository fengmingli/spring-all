package cn.lifengming.springexpand;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author lifengming
 * @date 2019-07-22 23:39
 */
@Service
public class UserService {

    @EventListener(classes={ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("Service...监听事件："+event);

    }

}
