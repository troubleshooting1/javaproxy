package com.conquer.dynamicproxy.CGlibproxy2;

import org.springframework.cglib.proxy.FixedValue;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/31 13:08
 */
public class DBQueryProxyFixedValue implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("Here in DBQueryProxyFixedValue ! ");
        return "Fixed Value";
    }
}
