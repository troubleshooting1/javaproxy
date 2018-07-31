package com.conquer.dynamicproxy.CGliblazyload;

import org.springframework.cglib.proxy.LazyLoader;

import java.util.Calendar;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/31 13:17
 */
public class ScheduleLazyLoader implements LazyLoader {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before LazyLoader init...you can query from db...");
        Schedule schedule=new Schedule();
        schedule.setCourseName("English");
        Calendar calendar=Calendar.getInstance();
        calendar.set(2017,3,28);
        schedule.setCourseTime(calendar.getTime());
        System.out.println("after LazyLoader init...");
        return schedule;
    }
}
