package com.lifengming.bean.service;

import com.lifengming.bean.config.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;

/**
 * @author lifengming
 * @since 2019.11.24
 */
@Component
public class UserOneService {


    @Demo
    UserTwoService userTwoService;

    public UserOneService() {
        System.out.println("constructor from UserOneService");
    }

    /**
     * 属性填充完成调用
     **/
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    public void getService() {
        System.out.println(userTwoService);
    }

    public void setUserTwoService(UserTwoService userTwoService) {
        this.userTwoService = userTwoService;
    }

    public static void main(String[] args) {
        UserOneService oneService = new UserOneService();
        Class<UserOneService> aClass = UserOneService.class;
        try {
            Field declaredField = aClass.getDeclaredField("userTwoService");
            if (declaredField.getAnnotation(Demo.class) != null) {
//                declaredField.setAccessible(true);
                declaredField.set(oneService, new UserTwoService());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
