package com.blog.frontend.interceptor.login;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@Slf4j
@Aspect
@Component
public class LoginRequireInterceptor {
    @Before("@annotation(loginRequire)")
    public void validateLogin(JoinPoint joinPoint, LoginRequire loginRequire) throws BaseException {
        Object[] params = joinPoint.getArgs();
        HttpSession session = (HttpSession ) Arrays.stream(params)
                .filter(item -> item instanceof HttpSession )
                .findFirst()
                .orElseThrow(BaseException::new);
        String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new BaseException(ErrorCodeEnum.NOT_LOGIN);
        } else {
            log.info("用户（{}）已登录", username);
        }
    }
}
