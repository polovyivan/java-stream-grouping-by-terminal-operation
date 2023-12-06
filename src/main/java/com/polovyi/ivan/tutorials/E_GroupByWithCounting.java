package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.Map;
import java.util.Set;

public class E_GroupByWithCounting {

    public static void main(String[] args) {
        Map<CustomerType, Long> groupByWithCounting = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType, counting()));
        MapUtils.print(groupByWithCounting);
    }
}
