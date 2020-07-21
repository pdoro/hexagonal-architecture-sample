package com.cel.hexarchsample.domain.model.vobjects;

public final class PhoneNumber {

    private final String rawPhoneNumber;

    public static PhoneNumber of(String rawPhoneNumber) {
        return new PhoneNumber(rawPhoneNumber);
    }

    private PhoneNumber(String rawPhoneNumber) {
        this.rawPhoneNumber = validate(rawPhoneNumber);
    }

    private String validate(String rawPhoneNumber) {
        return rawPhoneNumber;
    }

    @Override
    public String toString() {
        return mask(rawPhoneNumber);
    }

    private String mask(String rawPhoneNumber) {
        return "******" + rawPhoneNumber.substring(rawPhoneNumber.length() - 3);
    }

    public String rawValue() {
        return rawPhoneNumber;
    }
}
