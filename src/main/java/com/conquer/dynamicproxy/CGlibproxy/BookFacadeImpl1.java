package com.conquer.dynamicproxy.CGlibproxy;

/**
 * Description: 首先定义业务类，无需实现接口（当然，实现接口也可以，不影响的）
 * author: chenqiang
 * date: 2018/7/31 10:03
 */
public class BookFacadeImpl1 {
    public void addBook(){
        System.out.println("新增图书...");
    }
}
