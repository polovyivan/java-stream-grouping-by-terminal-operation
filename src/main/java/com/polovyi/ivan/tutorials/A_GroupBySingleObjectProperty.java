package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A_GroupBySingleObjectProperty {


    public static void main(String[] args) {
        Map<Customer.CustomerType, List<Customer>> customersByType = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "type"))
                .stream()
                .collect(groupingBy(Customer::getType));
        MapUtils.print(customersByType);

        System.out.println("============================================================");

        Map<Boolean, List<Customer>> customersByActive = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "isActive"))
                .stream()
                .collect(groupingBy(Customer::getIsActive));
        MapUtils.print(customersByActive);

        System.out.println("============================================================");

        System.out.println("Group by customer State (nested object)");
        Map<String, List<Customer>> groupByCustomerState = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "address"))
                .stream()
                .collect(groupingBy(c -> c.getAddress().getState()));
        MapUtils.print(groupByCustomerState);
    }

}
