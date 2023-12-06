package com.polovyi.ivan.tutorials;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.util.Map;
import java.util.Set;

public class I_GroupByWithSum {

    public static void main(String[] args) {
        Map<CustomerType, Long> groupByTypeAndPurchaseSum = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType,
                        summingLong(Customer::getPurchaseQty)));
        MapUtils.print(groupByTypeAndPurchaseSum);
    }
}
