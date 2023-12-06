package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.Address;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class F_GroupingByWithIdentityAndCounting {

    public static void main(String[] args) {
        Map<String, Long> collect = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .map(Customer::getAddress)
                .map(Address::getState)
                .collect(groupingBy(Function.identity(), counting()));
        MapUtils.print(collect);
    }
}
