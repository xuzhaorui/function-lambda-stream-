package com.fls.base;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // 初始化用户列表
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25));
        users.add(new User("Bob", 35));
        users.add(new User("Charlie", 28));
        users.add(new User("David", 40));

        // 1. 使用 Predicate 函数式接口筛选出年龄大于30岁的用户
        Predicate<User> ageGreaterThan30 = user -> user.getAge() > 30;
        List<User> filteredUsers = filterUsers(users, ageGreaterThan30);

        System.out.println("Age greater than 30: " + filteredUsers);

        // 2. 使用 Consumer 函数式接口对符合条件的用户进行操作（例如发送邮件）
        Consumer<User> sendEmail = user -> System.out.println("Sending email to " + user.getName());
        processUsers(filteredUsers, sendEmail);

        // 3. 使用 Function 函数式接口对用户对象进行某种转换（例如返回用户姓名）
        Function<User, String> userNameFunction = User::getName;
        List<String> userNames = mapUsers(filteredUsers, userNameFunction);

        System.out.println("Filtered user names: " + userNames);
    }


    // 使用 Predicate 函数式接口进行筛选
    public static List<User> filterUsers(List<User> users, Predicate<User> condition) {
        List<User> users30 = new ArrayList<>();
        for (User user : users) {
            if (condition.test(user)) {
                users30.add(user);
            }
        }
        return users30;
    }

    // 使用 Consumer 函数式接口对用户进行操作
    public static void processUsers(List<User> users, Consumer<User> action) {
        for (User user : users) {
            action.accept(user);
        }
    }

    // 使用 Function 函数式接口对用户对象进行转换
    public static <R> List<R> mapUsers(List<User> users, Function<User, R> mapper) {
        List<R> result = new ArrayList<>();
        for (User user : users) {
            result.add(mapper.apply(user));
        }
        return result;
    }
}
