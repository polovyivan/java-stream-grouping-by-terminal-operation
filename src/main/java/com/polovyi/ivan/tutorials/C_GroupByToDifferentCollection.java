package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toUnmodifiableSet;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class C_GroupByToDifferentCollection {

    public static void main(String[] args) {
        Map<CustomerType, Set<Customer>> valuesAsSet = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType, toSet()));
        MapUtils.print(valuesAsSet);
        System.out.println("===============================================");
        Map<CustomerType, Set<Customer>> valuesAsUnmodifiableSet = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType, toUnmodifiableSet()));
        MapUtils.print(valuesAsUnmodifiableSet);

        System.out.println("===============================================");
        LinkedHashSet<Customer> myHashSet = new LinkedHashSet();
        FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType, toCollection(() -> myHashSet)));
        MapUtils.print(myHashSet);
    }
}
