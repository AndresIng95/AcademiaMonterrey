package base;
import java.util.ArrayList;
import java.util.List;

public class Carrito<T extends Producto> {

	//Hace que para en el main acepte nuevos objetos que sean parte de Producto, sin especificar que tipo de producto es
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }
}
