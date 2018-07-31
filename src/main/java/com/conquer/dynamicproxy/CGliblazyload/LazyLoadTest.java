package com.conquer.dynamicproxy.CGliblazyload;

/**
 * Description: 懒加载
 * 于LazyLoader只有在第一次调用时，会执行loadObject获取对象，而Dispatcher会在每次调用时都触发loadObject方法
 * author: chenqiang
 * date: 2018/7/31 13:24
 */
public class LazyLoadTest {
    public static void main(String[] args) {
        Student student = new Student(666, "XiaoMing");
        System.out.println("id=" + student.getId());
        System.out.println("name=" + student.getName());
        // LazyLoader 只有第一次，Dispatcher是每次都会进loadObject的方法
        System.out.println("========First Get  EnglishSchedule ========");
        System.out.println(student.getEnglishSchedule());
        System.out.println();
        System.out.println("========First Get  MathSchedule ========");
        System.out.println(student.getMathSchedule());
        System.out.println();
        //第二次取懒加载对象的时候，实现LoadLazy接口不会重新执行loadObject
        System.out.println("========Second Get  EnglishSchedule ========");
        System.out.println(student.getEnglishSchedule());
        System.out.println();
        System.out.println("========Second Get  MathSchedule ========");
        System.out.println(student.getMathSchedule());
    }
}
