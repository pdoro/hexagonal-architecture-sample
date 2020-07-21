package com.cel.hexarchsample.infrastructure.adapter.database.inmemory;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.vobjects.PhoneNumber;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.secondary.CustomerRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("local")
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<CustomerId, Customer> storage;

    public InMemoryCustomerRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public Optional<Customer> findById(CustomerId id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Optional<Customer> findByPhone(PhoneNumber phoneNumber) {
        return storage.values()
            .stream()
            .filter(customer -> customer.getPhoneNumber().equals(phoneNumber))
            .findFirst();
    }

    @Override
    public void save(Customer newCustomer) {
        storage.put(newCustomer.getId(), newCustomer);
    }
}
