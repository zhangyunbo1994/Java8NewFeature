package com.zhangyunbo.lamdba;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test1 {

    List<Employee> list = Arrays.asList(
            new Employee("3", 15, 500),
            new Employee("4", 25, 6000),
            new Employee("5", 35, 6000),
            new Employee("6", 45, 6000),
            new Employee("7", 55, 6000),
            new Employee("8", 65, 6000),
            new Employee("9", 75, 7000)
    );

    @Test
    public void test1() {
        list.stream()
                .filter((e) -> e.getAge() > 20)
                .limit(10)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        int ret = this.operation(3, (x) ->
                x * x
        );

        System.out.println(ret);

    }

    private int operation(int num, MyFun myFun) {
        return myFun.getValue(num);
    }

}

@FunctionalInterface
interface MyFun {
    int getValue(int num);
}
