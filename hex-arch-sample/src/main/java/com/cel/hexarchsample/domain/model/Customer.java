
package com.cel.hexarchsample.domain.model;

import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.model.vobjects.PhoneNumber;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class Customer {

    private CustomerId id;
    private String customerName;
    private PhoneNumber phoneNumber;
    private Collection<Product> products;

    private Customer(CustomerId id, String customerName, PhoneNumber phoneNumber, Collection<Product> products)
    {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

    public static Customer newOne(String customerName, PhoneNumber phone) {
        return new Customer(
            CustomerId.of(UUID.randomUUID()),
            customerName,
            phone,
            Collections.emptyList()
        );
    }

    public static Customer restore(CustomerId customerId, String customerName, PhoneNumber phone, Collection<Product> products) {
        return new Customer(
            customerId,
            customerName,
            phone,
            products
        );
    }

    public CustomerId getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public Customer withProducts(Collection<Product> products) {
        this.products = products;
        return this;
    }
}
