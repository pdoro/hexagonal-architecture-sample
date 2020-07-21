package com.cel.hexarchsample.infrastructure.adapter.middleware;

import com.cel.hexarchsample.domain.model.Product;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import com.cel.hexarchsample.domain.port.secondary.ExternalService;
import java.util.Collection;
import java.util.Collections;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!local")
public class ThirdPartyService implements ExternalService {

    @Override
    public Collection<Product> fetchProductsFrom(CustomerId id) {
        return Collections.emptyList();
    }
}
