package com.conquer.dynamicproxy.CGliblazyload;

import lombok.Data;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Description:
 * author: chenqiang
 * date: 2018/7/31 13:21
 */
@Data
public class Student {
    private int id;
    private String name;
    private Schedule EnglishSchedule;
    private Schedule MathSchedule;

    public Student(int id, String name){
        this.id=id;
        this.name=name;
        this.EnglishSchedule=createEnglishSchedule();
        this.MathSchedule=createMathSchedule();
    }

    private Schedule createEnglishSchedule() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Schedule.class);
        enhancer.setCallback(new ScheduleLazyLoader());
        return (Schedule) enhancer.create();
    }

    private Schedule createMathSchedule() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Schedule.class);
        enhancer.setCallback(new ScheduleDispatcher());
        return (Schedule) enhancer.create();
    }

}
