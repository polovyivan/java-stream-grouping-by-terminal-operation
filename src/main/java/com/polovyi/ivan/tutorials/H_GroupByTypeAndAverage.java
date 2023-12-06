package com.polovyi.ivan.tutorials;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.averagingLong;
import static java.util.stream.Collectors.groupingBy;

import com.polovyi.ivan.tutorials.utils.Customer;
import com.polovyi.ivan.tutorials.utils.Customer.CustomerType;
import com.polovyi.ivan.tutorials.utils.FakeCustomersDao;
import com.polovyi.ivan.tutorials.utils.MapUtils;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class H_GroupByTypeAndAverage {

    public static void main(String[] args) {
        Map<CustomerType, Double> oldestCustomerInEachGroup = FakeCustomersDao
                .retrieveCustomers()
                .stream()
                .collect(groupingBy(Customer::getType,
                        averagingLong(
                                c -> Duration.ofDays(DAYS.between(c.getCreatedAt(), LocalDate.now())).toDays())));
        MapUtils.print(oldestCustomerInEachGroup);
    }
}
