package com.conquer.dynamicproxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: 代理对象
 * author: chenqiang
 * date: 2018/7/30 10:42
 */
public class TransactionHandler implements InvocationHandler {

    //需要代理的目标对象
    //这里设计为可以为任意对象添加事务控制, 所以将目标对象声明为Object
    private Object target;

    public TransactionHandler(Object target) {
        this.target = target;
    }

    /**
     * 绑定业务对象并返回一个代理类
     */
    public Object bind(Object target) {
        this.target = target;  //接收业务实现类对象参数

        //通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
        //创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用目标方法前的处理
        System.out.println("开启事务控制...");
        //调用目标对象的方法
        Object result = method.invoke(target, args);
        //调用目标方法后的处理
        System.out.println("关闭事务控制");
        return result;
    }
}
