package com.cel.hexarchsample.infrastructure.adapter.rest.model.response;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountInfoResponse {

    private String id;
    private String username;
    private String phoneNumber;
    private Collection<ProductResponse> products;

}
