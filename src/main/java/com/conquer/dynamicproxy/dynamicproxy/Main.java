package com.conquer.dynamicproxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/30 10:48
 */
public class Main {
    public static void main(String[] args) {
        //新建目标对象
        Object target=new UserDaoImpl();

        //创建事务处理器
        TransactionHandler handler=new TransactionHandler(target);

        //生成代理类并使用接口对其进行引用
        UserDao userDao=(UserDao) handler.bind(target);

        userDao.save();
    }
}
