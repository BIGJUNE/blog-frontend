package com.blog.frontend.util;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/18
 */
public class CommonUtils {
    private CommonUtils() {

    }

    public static<T, K> T copyBean(K source, Class<T> clazz) throws BaseException {

        T target;
        try {
            target = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new BaseException(ErrorCodeEnum.UNKNOWN_EXCEPTION, e.getMessage());
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static<T, K> List<T> copyBeanList(List<K> sourceList, Class<T> clazz) throws BaseException {
        List<T> targetList = new ArrayList<>();
        for(K source: sourceList) {
            targetList.add(CommonUtils.copyBean(source, clazz));
        }
        return targetList;
    }
}
