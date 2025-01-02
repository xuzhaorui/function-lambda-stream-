package com.fls.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
class Account{
    private String accountNumber;
    private Double balance;

}
public class PredicateAndPredicateDemo {
    static List<Account> accounts = Arrays.asList(
            new Account("LFKAFKLA",45453.22),
            new Account("HFLKAJFLK",6622.3),
            new Account("454G654AG6",634.1),
             new Account("6V4Z6VQVA",166955.1)
    );
    /**
     * 业务场景：
     * 你在处理一个银行账户系统，其中每个账户都包含一个余额。
     * 系统需要筛选出余额超过一定数值的账户，并将其余额转换为一个折扣后的值
     * （比如余额大于1000的账户将折扣5%）。使用 Predicate<Account> 筛选账户，然后使用 Function<Account, Account> 计算折扣后的余额。
     *
     * 要求：
     * 提供一个账户列表，账户包含 accountNumber 和 balance。
     * 使用 Predicate<Account> 过滤余额大于某个值的账户。
     * 使用 Function<Account, Account> 计算折扣后的余额，并返回更新后的账户列表。
     * @param args
     */

    public static void main(String[] args) {


        filterAndDiscount(accounts,(account -> account.getBalance() > 1000),(account -> {
            account.setBalance( account.getBalance() * 0.95);
            return account;
        })).forEach(System.out::println);
    }
    public static List<Account> filterAndDiscount(List<Account> accounts, Predicate<Account> predicate, Function<Account, Account> function) {
        List<Account> result = new ArrayList<>();
        accounts.forEach((account)->{
            if (predicate.test(account)) {
                result.add(function.apply(account));
            }
        });
        return result;
    }
}
