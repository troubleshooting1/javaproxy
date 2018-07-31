package com.conquer.dynamicproxy.CGlibproxy2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * Description: 多回调
 * author: chenqiang
 * date: 2018/7/31 11:17
 */
public class TestCGLibProxy2 {
    public static void main(String[] args) {
        DBQueryProxy dbQueryProxy = new DBQueryProxy();
        DBQueryProxy2 dbQueryProxy2 = new DBQueryProxy2();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DBQuery.class);
        enhancer.setCallbacks(new Callback[]{dbQueryProxy, dbQueryProxy2});

        //通过CallbackFilter来决定是使用哪个切入类
        enhancer.setCallbackFilter(new CallbackFilter() {
            public int accept(Method method) {
                if (method.getName().equals("getElement")) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        DBQuery dbQuery = (DBQuery) enhancer.create();
        System.out.println("========Inteceptor By DBQueryProxy ========");
        System.out.println(dbQuery.getElement("Hello"));
        System.out.println();
        System.out.println("========Inteceptor By DBQueryProxy2 ========");
        System.out.println(dbQuery.getAllElements());

    }
}
