package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingByConcurrent;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class N_ConcurrentGroupBy {

    public static void main(String[] args) {
        ConcurrentMap<CustomerType, List<Customer>> groupingByConcurrent = FakeCustomersDao
                .retrieveCustomers()
                .parallelStream()
                .collect(groupingByConcurrent(Customer::getType));
        MapUtils.print(groupingByConcurrent);
    }
}
