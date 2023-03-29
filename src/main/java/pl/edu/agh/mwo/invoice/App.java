package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.Product;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        DairyProduct product = new DairyProduct("Jajka", new BigDecimal(10));
        DairyProduct product2 = new DairyProduct("Mleko", new BigDecimal(5));
        DairyProduct product3 = new DairyProduct("Jablka", new BigDecimal(7));


    }

}
