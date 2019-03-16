package pl.sda.additional;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private BigDecimal salary;
    private static int counter = 1;

    {
        id = counter++;
    }

    public Customer(String firstName, String lastName, int age, int salary) {
        this(firstName, lastName, age, BigDecimal.valueOf(salary));
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.salary = BigDecimal.valueOf(salary);
    }

    public Customer(String firstName, String lastName, int age, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        this.salary = Optional.ofNullable(salary)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(BigDecimal::valueOf)
                .orElse(null);
//        To samo co powyzszy zapis z Optionalem
//        this.salary = salary == null ? null :
//                BigDecimal.valueOf(Integer.parseInt(salary.trim()));
    }

    private Customer(String firstName, String lastName, int age, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
}
