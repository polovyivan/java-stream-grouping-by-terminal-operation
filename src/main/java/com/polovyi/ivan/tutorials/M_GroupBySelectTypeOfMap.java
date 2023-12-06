package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class M_GroupBySelectTypeOfMap {

    public static void main(String[] args) {
        LinkedHashMap<CustomerType, List<Customer>> differentTypeOfMAp = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType,
                        LinkedHashMap::new, toList()));
        MapUtils.print(differentTypeOfMAp);

        System.out.println("===========================================================");
        LinkedHashMap<CustomerType, List<Customer>> myMap = new LinkedHashMap<>();
        FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType,
                        () -> myMap, toList()));
        MapUtils.print(myMap);
    }
}
