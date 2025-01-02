package com.fls.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

@Data
@AllArgsConstructor
class Message{
    private String name;
    private String content;
}

public class BiConsumerDemo {
    /**
     * 业务场景：
     * 你在设计一个聊天系统，每条消息需要记录用户的姓名和消息内容。
     * 使用 BiConsumer<String, String> 接口实现一个方法，
     * 该方法将用户的姓名和消息内容组合起来并打印到控制台上，模拟消息记录的功能。
     *
     * 要求：
     * 假设你有一个用户姓名和消息内容的列表。
     * 使用 BiConsumer<String, String> 实现消息记录。
     * @param args
     */
    static List<Message> messages = Arrays.asList(new Message("张三", "你好"), new Message("李四", "再见"));
    public static void main(String[] args) {
        printMessageLogging(messages,(name,content) -> System.out.println(name + ":" + content));

    }

    public static void printMessageLogging(List<Message> messages, BiConsumer<String,String> consumer){
        messages.forEach(message -> consumer.accept(message.getName(),message.getContent()));
    }
}
