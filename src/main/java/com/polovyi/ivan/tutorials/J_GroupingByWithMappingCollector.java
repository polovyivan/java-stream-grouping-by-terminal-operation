package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.List;
import java.util.Map;

public class J_GroupingByWithMappingCollector {

    public static void main(String[] args) {
        Map<CustomerType, List<String>> gropingByAndMapping = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType,
                        mapping(Customer::getName, toList())));

        MapUtils.print(gropingByAndMapping);
    }
}
