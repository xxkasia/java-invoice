package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.Product;



public class Invoice {

    private int invoiceNumber = 0;
    private static int lastInvoiceNumber = 0;

    public Invoice() {
        invoiceNumber = ++lastInvoiceNumber;
    }

    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }



    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public void print() {
        String text = "";
        int positions = 0;

        text += "Invoice number: " + Integer.toString(invoiceNumber) + "\n";

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            text += entry.getKey() + " "; // dodaje nazwe - wywoluje sie toString()
            text += "Quantity: " + entry.getValue() + "\n" ; // dodaje ilosc
            positions ++;
        }
        text += "Liczba pozycji: " + Integer.toString(positions);
        System.out.println(text + "\n");
    }


}

