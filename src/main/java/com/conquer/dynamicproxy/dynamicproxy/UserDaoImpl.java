package com.conquer.dynamicproxy.dynamicproxy;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/30 10:41
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("保存用户信息...");
    }
}
