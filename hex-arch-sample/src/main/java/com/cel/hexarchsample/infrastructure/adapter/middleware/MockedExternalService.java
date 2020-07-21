package com.cel.hexarchsample.infrastructure.adapter.middleware;

import com.cel.hexarchsample.domain.model.Product;
import com.cel.hexarchsample.domain.model.vobjects.Money;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.secondary.ExternalService;
import com.google.common.collect.Lists;
import java.util.Collection;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class MockedExternalService implements ExternalService {

    private static final Collection<Product> PRODUCTS = Lists.newArrayList(
        new Product("Apple XR",     Money.euros(100), 10),
        new Product("Samsung 10",   Money.dollars(50), 7),
        new Product("Google Pixel", Money.euros(100), 10),
        new Product("One Plus 8",   Money.yen(20), 10)
    );

    @Override
    public Collection<Product> fetchProductsFrom(CustomerId id) {
        return PRODUCTS;
    }
}
