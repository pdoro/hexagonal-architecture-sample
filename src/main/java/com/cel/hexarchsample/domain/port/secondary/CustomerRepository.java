package com.cel.hexarchsample.domain.port.secondary;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.vobjects.PhoneNumber;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(CustomerId id);
    Optional<Customer> findByPhone(PhoneNumber phoneNumber);

    void save(Customer newCustomer);
}
