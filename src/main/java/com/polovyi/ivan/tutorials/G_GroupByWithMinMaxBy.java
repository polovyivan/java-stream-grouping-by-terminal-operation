package com.polovyi.ivan.tutorials;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class G_GroupByWithMinMaxBy {

    public static void main(String[] args) {
        Map<CustomerType, Optional<Customer>> oldestCustomerInEachGroup = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "createdAt", "type"))
                .stream()
                .collect(groupingBy(Customer::getType, minBy(comparing(Customer::getCreatedAt))));
        MapUtils.print(oldestCustomerInEachGroup);
        System.out.println(" =========================================================== " );
        Map<CustomerType, Optional<Customer>> newestCustomerInEachGroup = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "createdAt", "type"))
                .stream()
                .collect(groupingBy(Customer::getType, maxBy(comparing(Customer::getCreatedAt))));
        MapUtils.print(newestCustomerInEachGroup);
    }
}
