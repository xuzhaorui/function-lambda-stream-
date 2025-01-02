package com.fls.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryOperatorDemo {
    /**
     * 业务场景：
     * 你有一个在线购物平台，其中有一组商品，每个商品的价格在特定的促销期间需要进行调整。
     * 使用 UnaryOperator<Double> 来实现一个方法，该方法将对商品的价格列表进行统一折扣（比如 10% 折扣）。
     *
     * 要求：
     * 提供一个商品价格的列表 List<Double>。
     * 使用 UnaryOperator<Double> 来调整每个商品的价格。
     * 输出折扣后的商品价格列表。
     * @param args
     */
    static List<Double> doubles;
    static {
        doubles = Arrays.asList(100.45, 200.22, 300.1, 400.4, 500.8);
    }
    public static void main(String[] args) {

    UnaryOperator<Double> discount = (price) -> price * 0.9;
    discount(doubles, discount).forEach(System.out::println);

    }
    //以将 discount 方法改成使用 map 操作，这样能够更加简洁地处理集合元素。
    public static List<Double> discount(List<Double> doubles, UnaryOperator<Double> operator){
      return   doubles.stream().map(operator).collect(Collectors.toList());
    }
//    public static List<Double> discount(List<Double> doubles, UnaryOperator<Double> operator){
//        List<Double> discountDoubles = new ArrayList<>();
//
//        doubles.forEach((originalPrice) -> discountDoubles.add(operator.apply(originalPrice)));
//        return discountDoubles;
//    }
}
