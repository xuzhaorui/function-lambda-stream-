package com.fls.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

@Data
@AllArgsConstructor
class Employee {
    private String name;
    private Double monthlySalary;
}


@Data
@AllArgsConstructor
class ComputeEmployee {
    private String name;
    private Double annualSalaryAddBonusValue;
}

public class BiFunctionDemo {
    static  List<Employee> employees;
    static  {
        employees = Arrays.asList(
                new Employee("张三",3000.8),
                new Employee("里斯",1556.78),
                new Employee("王五",4646.22)
        );
    }

    /**
     * 业务场景：
     * 假设你有一个系统需要计算员工的年薪，员工的月薪信息存储在数据库中。
     * 系统还需要考虑每个员工的年度奖金。给定一个 Employee
     * 类和一个 Double 类型的奖金比例，使用 BiFunction<Employee, Double, Double> 实现一个方法，计算每个员工的年薪（包括奖金），并将结果存储到一个新的列表中。
     *
     * 要求：
     * Employee 类包含员工的 name 和 monthlySalary 属性。
     * 使用 BiFunction<Employee, Double, Double> 来计算年薪。
     * 最终你将返回每个员工的姓名和年薪（包含奖金）的列表。
     * @param args
     */
    public static void main(String[] args) {
        BiFunction<Employee, Double, Double> biFunction = (employee, bonusRatio) -> employee.getMonthlySalary() * 12 * (1 + bonusRatio);
        List<ComputeEmployee> compute = compute(employees, 0.2, biFunction);
        compute.forEach(System.out::println);
    }

    public static List<ComputeEmployee>  compute(List<Employee> employees, Double bonusRatio, BiFunction<Employee, Double, Double> biFunction){
        List<ComputeEmployee> computeEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            ComputeEmployee computeEmployee = new ComputeEmployee(employee.getName(), biFunction.apply(employee, bonusRatio));
            computeEmployees.add(computeEmployee);
        }
        return computeEmployees;
    }
}
