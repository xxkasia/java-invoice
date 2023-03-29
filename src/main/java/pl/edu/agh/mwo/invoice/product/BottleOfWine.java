package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class BottleOfWine extends Product {

    private final BigDecimal EXCISE = new BigDecimal("5.56");

    protected BottleOfWine(String name, BigDecimal price, BigDecimal tax) {
        super(name, price, tax);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(EXCISE);
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
