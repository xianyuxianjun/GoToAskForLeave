package com.chenxianyu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ObjectCopier {
    /**
     * 将源对象的数据复制到目标对象中。
     *
     * @param source 源对象
     * @param target 目标对象
     * @throws IllegalAccessException 如果无法访问属性
     * @throws InvocationTargetException 如果调用属性方法失败
     */
    public static void copyProperties(Object source, Object target) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperties(target, source);
    }
}
