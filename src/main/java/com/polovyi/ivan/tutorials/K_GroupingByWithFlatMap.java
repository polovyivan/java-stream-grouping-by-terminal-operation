package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.Map;
import java.util.Set;

public class K_GroupingByWithFlatMap {

    public static void main(String[] args) {
        Map<CustomerType, Set<String>> groupingWithFlatMapping = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType,
                        flatMapping(customer -> customer.getPaymentMethods().stream(), toSet())));
        MapUtils.print(groupingWithFlatMapping);
    }
}
