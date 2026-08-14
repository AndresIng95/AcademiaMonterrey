package base;
import java.util.Comparator;

public class ProductComparator {

    public static Comparator<Producto> byName() {
        return Comparator.comparing(Producto::getName);
    }

    public static Comparator<Producto> byPrice() {
        return Comparator.comparing(Producto::getPrice);
    }
}