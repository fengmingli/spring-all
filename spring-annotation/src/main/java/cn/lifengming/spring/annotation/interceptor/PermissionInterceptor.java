package cn.lifengming.spring.annotation.interceptor;

import cn.lifengming.spring.annotation.annnotation.PermissionLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lifengming
 * @since 09.09.2019
 */
@Slf4j
@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        log.info("自定义拦截器");
        HandlerMethod handlerMethod = (HandlerMethod) obj;
        Method method = handlerMethod.getMethod();
        Annotation[] annotations = method.getAnnotations();
        for (Annotation anno : annotations) {
            if (anno.annotationType().equals(PermissionLimit.class)) {
                System.out.println("注解测试成功");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) {
        log.info("处理请求完成后视图渲染之前的处理操作");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {
        log.info("视图渲染之后的操作");
    }
}
