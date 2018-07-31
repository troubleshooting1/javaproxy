package com.conquer.dynamicproxy.staticproxy;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/30 10:39
 */
public class Main {
    public static void main(String[] args) {
        UserDaoImpl target = new UserDaoImpl();

        UserDao userDao = new TransactionHandler(target);

        userDao.save();
    }
}
