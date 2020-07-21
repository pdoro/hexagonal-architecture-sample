package com.cel.hexarchsample.infrastructure.adapter.rest.mapper;

import com.cel.hexarchsample.domain.model.Customer;
import com.cel.hexarchsample.domain.model.Product;
import com.cel.hexarchsample.infrastructure.adapter.rest.model.response.AccountInfoResponse;
import com.cel.hexarchsample.infrastructure.adapter.rest.model.response.ProductResponse;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseMapper {

    public static AccountInfoResponse map(Customer customer) {

        Collection<ProductResponse> productResponses = customer.getProducts()
            .stream()
            .map(ResponseMapper::map)
            .collect(Collectors.toList());

        return AccountInfoResponse.builder()
            .id(customer.getId().toString())
            .username(customer.getCustomerName())
            .phoneNumber(customer.getPhoneNumber().toString())
            .products(productResponses)
            .build();
    }

    public static ProductResponse map(Product product) {
        return ProductResponse.builder()
            .productName(product.name())
            .priceEur(product.subtotal().value.longValue())
            .build();
    }
}
