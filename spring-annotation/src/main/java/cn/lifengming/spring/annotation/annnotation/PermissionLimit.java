package cn.lifengming.spring.annotation.annnotation;

import java.lang.annotation.*;

/**
 * @author lifengming
 * @since 09.09.2019
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionLimit {
    /**
     * 登录拦截 (默认拦截)
     */
    boolean limit() default true;

    /**
     * 要求管理员权限
     *
     * @return
     */
    boolean adminuser() default false;

}
