package com.zhangyunbo.lamdba;



import org.junit.Test;

import java.util.function.Consumer;

/**
 * 方法引用：如果lambda体中内容有方法已经实现，我们可以使用"方法引用"
 *
 * 1. 对象::实例方法名
 * 2. 类::静态方法名
 * 3. 类::实例方法名
 */
public class Test2 {


    @Test
    public void test1() {
        Consumer<Double> con = Test2::print_1;// 这里理解起来就是直接对里面的方法进行重写；并且呢这个重写的方法其实已经存在了
        con.accept(23.23);
    }

    public static void print_1(double money) {
        System.out.println("消费" + money + "元");
    }
}