package com.cel.hexarchsample.infrastructure.adapter.database.jpa.mapper;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.vobjects.PhoneNumber;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.infrastructure.adapter.database.jpa.model.CustomerEntity;
import java.util.Collections;

public final class JPAEntityMapper {

    public static Customer fromEntity(CustomerEntity entity) {
        return Customer.restore(
            CustomerId.of(entity.getCustomerId()),
            entity.getName(),
            PhoneNumber.of(entity.getPhoneNumber()),
            Collections.emptyList()
        );
    }

    public static CustomerEntity intoEntity(Customer customer) {
        return new CustomerEntity(
            customer.getId().value,
            customer.getCustomerName(),
            customer.getPhoneNumber().rawValue()
        );
    }

}
