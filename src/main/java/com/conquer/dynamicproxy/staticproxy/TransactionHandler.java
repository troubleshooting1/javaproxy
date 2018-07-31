package com.conquer.dynamicproxy.staticproxy;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/30 10:37
 */
public class TransactionHandler implements UserDao {

    //目标代理对象
    private UserDaoImpl target;

    //构造代理对象时传入目标对象
    public TransactionHandler(UserDaoImpl target){
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("开启事务控制...");
        target.save();
        System.out.println("关闭事务控制...");
    }
}
