package b_Money;

public class Currency {

    private String name;
    private Double rate;

    /**
     * New Currency
     */
    public Currency(String name, Double rate) {

        this.name = name;
        this.rate = rate;
    }

    /**
     * Convert amount to universal currency value
     */
    public Integer universalValue(Integer amount) {

        return (int) (amount * rate);
    }

    /**
     * Get currency name
     */
    public String getName() {

        return name;
    }

    /**
     * Get currency rate
     */
    public Double getRate() {

        return rate;
    }

    /**
     * Set currency rate
     */
    public void setRate(Double rate) {

        this.rate = rate;
    }

    /**
     * Convert another currency into this currency
     */
    public Integer valueInThisCurrency(Integer amount,
                                       Currency othercurrency) {

        double universal = othercurrency.universalValue(amount);

        return (int) (universal / this.rate);
    }
}