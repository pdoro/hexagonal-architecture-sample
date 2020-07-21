package com.cel.hexarchsample.domain.adapter;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.Product;
import com.cel.hexarchsample.domain.model.vobjects.PhoneNumber;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.primary.CustomerCRUD;
import com.cel.hexarchsample.domain.port.secondary.CustomerRepository;
import com.cel.hexarchsample.domain.port.secondary.ExternalService;
import com.cel.hexarchsample.infrastructure.adapter.rest.model.request.CreateCustomerRequest;
import com.cel.hexarchsample.infrastructure.exception.CustomerNotFoundException;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCRUDService implements CustomerCRUD {

    private final CustomerRepository repository;
    private final ExternalService externalService;

    @Override
    public Customer fetch(CustomerId customerId) {
        Collection<Product> products = externalService.fetchProductsFrom(customerId);

        Customer customer = repository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException()
                .with("customerId", customerId));

        return customer.withProducts(products);
    }

    @Override
    public Customer create(CreateCustomerRequest order) {
        String customerName = order.getCustomerName();
        PhoneNumber phone = PhoneNumber.of(order.getCustomerPhone());

        Customer newCustomer = Customer.newOne(customerName, phone);
        repository.save(newCustomer);

        return newCustomer;
    }
}
