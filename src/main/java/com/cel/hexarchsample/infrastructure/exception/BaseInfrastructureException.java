package com.cel.hexarchsample.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseInfrastructureException extends RuntimeException {

    private final Map<String, Object> metadata;

    public BaseInfrastructureException() {
        this.metadata = new HashMap<>();
    }

    public BaseInfrastructureException with(String key, Object value) {
        metadata.put(key, value);
        return this;
    }

    public Map<String, Object> metadata() {
        return metadata;
    }
}
