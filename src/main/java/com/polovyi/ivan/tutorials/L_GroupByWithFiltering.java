package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.Map;
import java.util.Set;

public class L_GroupByWithFiltering {
    public static void main(String[] args) {
        Map<CustomerType, Set<Customer>> groupByWithFiltering = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "type", "paymentMethods"))
                .stream()
                .collect(groupingBy(Customer::getType,
                        filtering(customer -> !customer.getPaymentMethods()
                                .contains("CASH"), toSet())));
        MapUtils.print(groupByWithFiltering);
    }
}
