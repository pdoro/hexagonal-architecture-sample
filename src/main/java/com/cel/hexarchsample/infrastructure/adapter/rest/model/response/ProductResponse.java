package com.cel.hexarchsample.infrastructure.adapter.rest.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String productName;
    private long priceEur;
}
