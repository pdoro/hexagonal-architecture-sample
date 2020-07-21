package com.cel.hexarchsample.domain.port.primary;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.infrastructure.adapter.rest.model.request.CreateCustomerRequest;

public interface CustomerCRUD {

    Customer fetch(CustomerId customerId);

    Customer create(CreateCustomerRequest order);

}
