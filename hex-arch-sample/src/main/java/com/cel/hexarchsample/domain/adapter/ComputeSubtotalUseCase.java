package com.cel.hexarchsample.domain.adapter;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.Product;
import com.cel.hexarchsample.domain.model.vobjects.Money;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.primary.ComputeSubtotal;
import com.cel.hexarchsample.domain.port.primary.CustomerCRUD;
import com.cel.hexarchsample.domain.port.secondary.CustomerRepository;
import com.cel.hexarchsample.domain.port.secondary.ExternalService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComputeSubtotalUseCase implements ComputeSubtotal {

    private final CustomerCRUD customerCRUD;
    private final ExternalService externalService;

    @Override
    public Money computeSubtotalFor(CustomerId customerId) {

        // Verify client exists
        Customer customer = customerCRUD.fetch(customerId);

        Collection<Product> products = externalService.fetchProductsFrom(customer.getId());

        Money subtotal = products.stream()
            .map(Product::subtotal)
            .reduce(Money::sum)
            .orElseThrow(IllegalStateException::new);

        return subtotal;
    }
}
