package pl.sda.additional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class CustomerService {

    Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250 "),
            new Customer("Adam", "Twardowski", 33, "4100 "),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333),
            new Customer("Adam", "Nowak ", 15, null)
    };

    public List<Customer> changeTheTableToList(Customer[] customers) {
        return Arrays.asList(customers);
    }

    public List<String> showListOfNamesFor(Customer[] customers) {
        List<String> listOfNames = new ArrayList<>();
        for (Customer customer : customers) {
            listOfNames.add(customer.getFirstName().trim() + " "
                    + customer.getLastName().trim());
        }
        return listOfNames;
    }

    public List<String> showListOfNamesStream(Customer[] customers) {
        return Arrays.stream(customers)
                .map(x -> x.getFirstName().trim() + " " + x.getLastName().trim())
                .collect(Collectors.toList());
    }

    public Map<String, Map<BigDecimal, Integer>> createTheMapOfMapsGroupingByNameAndSalary(Customer[] customers) {
        Map<String, Map<BigDecimal, Integer>> resultMap =
                new HashMap<>();
        for (Customer customer : customers) {
            if (resultMap.containsKey(customer.getFirstName().trim())) {
                Map<BigDecimal, Integer> innerMap = resultMap.get(customer.getFirstName().trim());
                if (innerMap.containsKey(customer.getSalary())) {
                    Integer counter = innerMap.get(customer.getSalary());
                    innerMap.put(customer.getSalary(), ++counter);
                } else {
                    Map<BigDecimal, Integer> innerMAp = new HashMap<>();
                    innerMAp.put(customer.getSalary(), 1);
                    resultMap.put(customer.getFirstName().trim(), innerMAp);
                }
            } else {
                Map<BigDecimal, Integer> innerMAp = new HashMap<>();
                innerMAp.put(customer.getSalary(), 1);
                resultMap.put(customer.getFirstName().trim(), innerMAp);
            }
        }
        return resultMap;
    }

    public Map<String, Map<BigDecimal, Long>> createTheMapOfMapsGroupingByNameAndSalaryWithStream(Customer[] customers) {
        return Arrays.stream(customers)
                .collect(groupingBy(c -> c.getFirstName().trim(),
                        groupingBy(c -> c.getSalary(), Collectors.counting())));
    }


}