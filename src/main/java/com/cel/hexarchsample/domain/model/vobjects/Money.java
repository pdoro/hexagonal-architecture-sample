package com.cel.hexarchsample.domain.model.vobjects;

import java.math.BigDecimal;

public final class Money {

    public final BigDecimal value;
    public final Currency currency;

    private Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money euros(long value) {
        return new Money(new BigDecimal(value), Currency.EUR);
    }
    public static Money dollars(long value) {
        return new Money(new BigDecimal(value), Currency.DOLLAR);
    }

    public static Money yen(long value) {
        return new Money(new BigDecimal(value), Currency.YEN);
    }

    public Money multiplyBy(long amount) {
        return new Money(value.multiply(new BigDecimal(amount)), currency);
    }

    public Money sum(Money money) {
        return new Money( value.add(money.value), currency);
    }

    public enum Currency {
        EUR,
        DOLLAR,
        YEN
    }
}
