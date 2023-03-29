package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanister extends Product {

    private final BigDecimal EXCISE = new BigDecimal("5.56");

    protected FuelCanister(String name, BigDecimal price) {
        super(name, price, BigDecimal.valueOf(0));
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }

    @Override
    public BigDecimal getTaxPercent() {
        return super.getTaxPercent();
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return super.getPriceWithTax().add(EXCISE);
    }
}
