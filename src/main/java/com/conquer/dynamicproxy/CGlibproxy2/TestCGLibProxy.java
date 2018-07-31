package com.conquer.dynamicproxy.CGlibproxy2;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Description: 单回调
 * author: chenqiang
 * date: 2018/7/31 11:12
 */
public class TestCGLibProxy {
    public static void main(String[] args) {
        DBQueryProxy dbQueryProxy=new DBQueryProxy();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(DBQuery.class);
        enhancer.setCallback(dbQueryProxy);

        DBQuery dbQuery=(DBQuery)enhancer.create();
        System.out.println(dbQuery.getElement("Hello"));
        System.out.println();
        System.out.println(dbQuery.getAllElements());
        System.out.println();
        System.out.println(dbQuery.sayHello());

    }
}
