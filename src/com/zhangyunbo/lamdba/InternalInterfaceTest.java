package com.zhangyunbo.lamdba;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InternalInterfaceTest {

    /**
     *
     * java8 内置四大核心函数式接口
     *
     * Consumer<T>: 消费性接口
     *      void accept(T t);
     *
     * Supplier<T>: 供给型接口
     *      T get();
     *
     * Function<T, R>: 函数型接口
     *      R apply(T t);
     *
     * Predicate<T>: 断言型接口
     *      boolean test(T t)
     *
     */

    /**
     * 消费型测试: 打印花费的钱
     */
    @Test
    public void test1() {
        this.operation(1000.01, (money) -> System.out.println("消费" + money + "元"));
    }

    private void operation(Double num, Consumer<Double> con) {
        con.accept(num);
    }

    /**
     * 供给型测试：生成指定个数的随机数
     */
    @Test
    public void test2() {
        List<Integer> numList = this.getNumList(10, () -> (int) (Math.random() * 1000));
        System.out.println(numList);
    }

    private List<Integer> getNumList(Integer num, Supplier<Integer> sup) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            result.add(n);
        }
        return result;
    }

    /**
     * 函数型测试：获取字符串的长度; 格式化字符串
     */
    @Test
    public void test3() {
        Object strLength = this.strHandler("   nihao    ueu", (str) -> str.length());
        System.out.println(strLength);

        Object trimStr = this.strHandler("   nihao    ", (str) -> str.trim());
        System.out.println(trimStr);

    }

    private Object strHandler(String str, Function<String, Object> fun) {
        return fun.apply(str);
    }

    /**
     * 断言型测试：将满足条件的字符串，放到集合中
     */
    @Test
    public void test4() {

        List<String> list = Arrays.asList("21", "eweew", "weewwewe", "3443gyj43gjy43f");
        List<String> strList = this.filterStr(list, (str) -> str.length() > 3);
        System.out.println(strList);

    }

    private List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str: list){
            if (pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }

}
