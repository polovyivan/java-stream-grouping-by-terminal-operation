package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class D_GroupByMultipleProperties {

    public static void main(String[] args) {
        Map<Boolean, Map<CustomerType, List<Customer>>> groupByIsActiveAndType = FakeCustomersDao
                .retrieveCustomers(Set.of("id", "name", "isActive", "type"))
                .stream()
                .collect(groupingBy(Customer::getIsActive, groupingBy(Customer::getType)));
        MapUtils.print(groupByIsActiveAndType);
    }
}
