package com.cel.hexarchsample.infrastructure.adapter.database.jpa;

import com.cel.hexarchsample.infrastructure.adapter.database.jpa.model.CustomerEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACustomerRepository extends PagingAndSortingRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByPhoneNumber(String phoneNumber);

}
