package com.cel.hexarchsample.domain.model.vobjects.ids;
import java.util.Objects;
import java.util.UUID;

public class CustomerId {

    public final UUID value;

    private CustomerId(UUID value) {
        this.value = value;
    }

    public static CustomerId of(UUID value) {
        return new CustomerId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerId that = (CustomerId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
