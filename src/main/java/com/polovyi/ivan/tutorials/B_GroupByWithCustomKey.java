package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class B_GroupByWithCustomKey {

    public static void main(String[] args) {

        System.out.println("Group by customer activity with custom key");
        Map<String, List<Customer>> customersByActiveWithCustomKey = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "isActive"))
                .stream()
                .collect(groupingBy(c -> c.getIsActive() ? "ACTIVE" : "NOT_ACTIVE"));
        MapUtils.print(customersByActiveWithCustomKey);

        System.out.println("Group by customer phone area code");
        Map<String, List<Customer>> groupByCustomerAreaCode = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "phoneNumber"))
                .stream()
                .collect(groupingBy(c -> c.getPhoneNumber().substring(1, 4)));
        MapUtils.print(groupByCustomerAreaCode);

    }

}
