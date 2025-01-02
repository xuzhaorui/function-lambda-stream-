package com.fls.base;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FourMajorInterfaces {
    // 四大接口
    public static void main(String[] args) {
        // 1. 消费者接口
        Consumer<String> consumer = System.out::println;

         // 2. 供给者接口
        Supplier<String> supplier = () -> "Hello World";
        String s = supplier.get();
        consumer.accept(s);

        // 3. 函数式接口
        Function<Integer, String> function = String::valueOf;

        String apply = function.apply(100);
        System.out.println(apply);

        // 4. 断言式接口
        Predicate<Integer> predicate = (i) -> i > 0;

        System.out.println(predicate.test(100));
    }

}
