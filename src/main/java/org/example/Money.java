package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal amount, String currency) {
    public Money {
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
    }

    public static Money of(double amount) {
        return new Money(BigDecimal.valueOf(amount), "UAH");
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
