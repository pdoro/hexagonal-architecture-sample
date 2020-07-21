package com.cel.hexarchsample.infrastructure.adapter.database.jpa;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.vobjects.PhoneNumber;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.secondary.CustomerRepository;
import com.cel.hexarchsample.infrastructure.adapter.database.jpa.mapper.JPAEntityMapper;
import com.cel.hexarchsample.infrastructure.adapter.database.jpa.model.CustomerEntity;
import com.cel.hexarchsample.infrastructure.exception.CustomerNotFoundException;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("!local")
@Repository
@RequiredArgsConstructor
public class DatabaseCustomerRepository implements CustomerRepository {

    private final JPACustomerRepository repository;

    @Override
    public Optional<Customer> findById(CustomerId id) {
        Objects.requireNonNull(id);

        return repository.findById(id.value)
            .map(JPAEntityMapper::fromEntity);
    }

    @Override
    public Optional<Customer> findByPhone(PhoneNumber phoneNumber) {
        Objects.requireNonNull(phoneNumber);

        return repository.findByPhoneNumber(phoneNumber.rawValue())
            .map(JPAEntityMapper::fromEntity);
    }

    @Override
    public void save(Customer newCustomer) {
        Objects.requireNonNull(newCustomer);

        CustomerEntity entity = JPAEntityMapper.intoEntity(newCustomer);
        repository.save(entity);
    }
}
