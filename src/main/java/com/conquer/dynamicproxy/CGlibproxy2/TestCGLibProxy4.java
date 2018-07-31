package com.conquer.dynamicproxy.CGlibproxy2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * Description: 固定值
 * author: chenqiang
 * date: 2018/7/31 13:09
 */
public class TestCGLibProxy4 {
    public static void main(String[] args) {
        DBQueryProxy dbQueryProxy = new DBQueryProxy();
        DBQueryProxy2 dbQueryProxy2 = new DBQueryProxy2();
        Callback noopCb = NoOp.INSTANCE;
        Callback fixedValue = new DBQueryProxyFixedValue();     //返回DBQueryProxyFixedValue中的值"Fixed Value"，不返回DBQuery中methodForFixedValue的值
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DBQuery.class);
        enhancer.setCallbacks(new Callback[]{dbQueryProxy, dbQueryProxy2, noopCb, fixedValue});
        enhancer.setCallbackFilter(new CallbackFilter() {

            public int accept(Method method) {
                if (method.getName().equals("getElement")) {
                    return 0;
                } else if (method.getName().equals("getAllElements")) {
                    return 1;
                } else if (method.getName().equals("methodForNoop")) {
                    return 2;
                } else if (method.getName().equals("methodForFixedValue")) {
                    return 3;
                } else {
                    return 0;
                }
            }
        });
        DBQuery dbQuery = (DBQuery) enhancer.create();
        System.out.println("========Inteceptor By DBQueryProxy ========");
        System.out.println(dbQuery.getElement("Hello"));
        System.out.println();
        System.out.println("========Inteceptor By DBQueryProxy2 ========");
        System.out.println(dbQuery.getAllElements());
        System.out.println();
        System.out.println("========Return Original Value========");
        System.out.println(dbQuery.methodForNoop());
        System.out.println();
        System.out.println("========Return Fixed Value========");
        System.out.println(dbQuery.methodForFixedValue("myvalue"));

    }
}
