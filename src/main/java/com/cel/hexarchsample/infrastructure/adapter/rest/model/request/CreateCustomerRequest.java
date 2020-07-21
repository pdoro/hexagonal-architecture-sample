package com.cel.hexarchsample.infrastructure.adapter.rest.model.request;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String customerName;
    private String customerPhone;
}
