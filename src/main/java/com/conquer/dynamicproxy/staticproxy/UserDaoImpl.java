package com.conquer.dynamicproxy.staticproxy;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/30 10:37
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("正在保存用户....");
    }
}
