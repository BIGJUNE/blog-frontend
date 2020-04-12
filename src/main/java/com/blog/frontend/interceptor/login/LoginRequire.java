package com.blog.frontend.interceptor.login;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequire {
    String OPERATION = "ALL";
    String RESOURCE = "ALL";
}
