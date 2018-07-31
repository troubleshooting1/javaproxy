package com.conquer.dynamicproxy.CGlibproxy2;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/31 11:10
 */
public class DBQueryProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Here is interceptor!");
        return methodProxy.invokeSuper(o, objects);
        //        return null;
    }
}
