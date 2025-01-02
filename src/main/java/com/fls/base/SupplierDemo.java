package com.fls.base;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierDemo {
    /**
     * 业务场景：
     * 你的系统中有一个功能，当用户第一次访问某个页面时，需要为该用户生成一个唯一的标识符（UUID）。
     * 使用 Supplier<String> 接口实现一个方法，每当用户访问时生成一个新的 UUID。
     *
     * 要求：
     * 每次调用 Supplier<String> 时，都应该生成一个新的 UUID。
     * 输出多次调用 Supplier 后的 UUID 列表。
     * @param args
     */
    public static void main(String[] args) {
        printUUID(6);
    }
    // 你可以考虑使用 Stream.generate 来生成 UUID 列表，这样可以减少循环代码的冗余。
    public static void printUUID(int count) {
        Stream.generate(() -> java.util.UUID.randomUUID().toString()).limit(count).forEach(System.out::println);
    }
//    public static void printUUID(int count) {
//        Supplier<String> uuidSupplier = () -> java.util.UUID.randomUUID().toString();
//        List<String> uuids = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            uuids.add(uuidSupplier.get());
//        }
//        System.out.println(uuids);
//
//    }
}
