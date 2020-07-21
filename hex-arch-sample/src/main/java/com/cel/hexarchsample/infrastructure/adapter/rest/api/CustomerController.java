package com.cel.hexarchsample.infrastructure.adapter.rest.api;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.vobjects.Money;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.primary.ComputeSubtotal;
import com.cel.hexarchsample.domain.port.primary.CustomerCRUD;
import com.cel.hexarchsample.infrastructure.adapter.rest.mapper.ResponseMapper;
import com.cel.hexarchsample.infrastructure.adapter.rest.model.request.CreateCustomerRequest;
import com.cel.hexarchsample.infrastructure.adapter.rest.model.response.AccountInfoResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerCRUD customerCRUD;
    private final ComputeSubtotal computeSubtotal;

    @GetMapping("/{customerId}")
    public AccountInfoResponse fetchCustomer(@PathVariable UUID customerId) {

        CustomerId id = CustomerId.of(customerId);
        Customer customer = customerCRUD.fetch(id);

        return ResponseMapper.map(customer);
    }

    @PostMapping
    public AccountInfoResponse createCustomer(@RequestBody CreateCustomerRequest request) {

        Customer customer = customerCRUD.create(request);
        return ResponseMapper.map(customer);
    }

    @GetMapping("/{customerId}/subtotal")
    public Money computeSubtotal(@PathVariable UUID customerId) {

        CustomerId id = CustomerId.of(customerId);
        Money subtotal = computeSubtotal.computeSubtotalFor(id);

        return subtotal;
    }
}
