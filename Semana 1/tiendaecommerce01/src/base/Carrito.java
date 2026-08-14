package base;
import java.util.ArrayList;
import java.util.List;

public class Carrito<T extends Producto> {

	//Hace que para en el main acepte nuevos objetos que sean parte de Producto, sin especificar que tipo de producto es
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
        
        //Area para agragar la adicion a la clase singleton de transaccion de tienda, si me deja usar ENUM seria esto
        Transacciontienda.INSTANCE.addIncome(product.getPrice());
    }

    public List<T> getProducts() {
        return products;
    }
    
    public double getTotal() {
        double total = 0;

        for (Producto product : products) {
            total += product.getPrice();
        }

        return total;
    }
}
