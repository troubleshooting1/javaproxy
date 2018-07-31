package com.conquer.dynamicproxy.CGlibproxy2;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/31 11:08
 */
public class DBQuery {

    public DBQuery(){

    }

    public DBQuery(Integer i){
        System.out.println("Here's in DBQuery Constructor");
    }

    public String getElement(String id) {
        return id + "_CGLib";
    }

    public List<String> getAllElements() {
        return Arrays.asList("Hello_CGLib1", "Hello_CGLib2");
    }

    public String methodForNoop() {
        return "Hello_Noop";
    }

    public String methodForFixedValue(String param) {
        return "Hello_" + param;
    }

    //这里定义为final类型，所以不会执行DBQueryProxy中的System.out.println("Here is interceptor!");
    public final String sayHello() {
        return "Hello Everyone！";
    }

}
