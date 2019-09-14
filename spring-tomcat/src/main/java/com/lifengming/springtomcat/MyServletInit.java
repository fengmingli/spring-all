package com.lifengming.springtomcat;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <p>tomcat启动的时候会执行{@link MyServletInit}，则是spi思想的实现。
 * 在 META—INF/services/文件夹下配置，在tomcat启动的时候实现{@link ServletContainerInitializer}
 * 接口的类都会执行
 * <p/>
 * <p>{@link HandlesTypes}注解会把所有的value读取到Set<Class<?>>里面，然后再去onStartup
 * </p>
 * @author lifengming
 * @since 14.09.2019
 */
@HandlesTypes(MyWebInitializer.class)
public class MyServletInit implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("servlet init");
        List<MyWebInitializer> initializers = new LinkedList<MyWebInitializer>();


        servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
        AnnotationAwareOrderComparator.sort(initializers);
        for (MyWebInitializer initializer : initializers) {
            initializer.onStartup(servletContext);
        }

    }
}
