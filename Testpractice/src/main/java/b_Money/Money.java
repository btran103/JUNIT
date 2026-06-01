package b_Money;

public class Money implements Comparable<Money> {

    private int amount;
    private Currency currency;

    /**
     * New Money
     */
    public Money(Integer amount, Currency currency) {

        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Return amount
     */
    public Integer getAmount() {

        return amount;
    }

    /**
     * Return currency
     */
    public Currency getCurrency() {

        return currency;
    }

    /**
     * Convert money to string
     */
    @Override
    public String toString() {

        double value = amount / 100.0;

        return value + " " + currency.getName();
    }

    /**
     * Universal value
     */
    public Integer universalValue() {

        return currency.universalValue(amount);
    }

    /**
     * Compare two money values
     */
    public Boolean equals(Money other) {

        return this.universalValue().equals(other.universalValue());
    }

    /**
     * Add money
     */
    public Money add(Money other) {

        Integer converted =
                currency.valueInThisCurrency(
                        other.getAmount(),
                        other.getCurrency());

        return new Money(amount + converted, currency);
    }

    /**
     * Subtract money
     */
    public Money sub(Money other) {

        Integer converted =
                currency.valueInThisCurrency(
                        other.getAmount(),
                        other.getCurrency());

        return new Money(amount - converted, currency);
    }

    /**
     * Check zero
     */
    public Boolean isZero() {

        return amount == 0;
    }

    /**
     * Negate money
     */
    public Money negate() {

        return new Money(-amount, currency);
    }

    /**
     * Compare monies
     */
    @Override
    public int compareTo(Money other) {

        return this.universalValue()
                .compareTo(other.universalValue());
    }
}