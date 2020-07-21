package com.cel.hexarchsample.domain.port.secondary;

import com.cel.hexarchsample.domain.model.Product;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;
import java.util.Collection;

public interface ExternalService {

    Collection<Product> fetchProductsFrom(CustomerId id);

}
