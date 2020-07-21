package com.cel.hexarchsample.domain.port.primary;

import com.cel.hexarchsample.domain.model.vobjects.Money;
import com.cel.hexarchsample.domain.model.vobjects.ids.CustomerId;

public interface ComputeSubtotal {

    Money computeSubtotalFor(CustomerId customerId);
}
