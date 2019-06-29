package products;

import java.util.ArrayList;
import java.util.List;

public class CreateProducts<T extends Product> {
    private List<T> products;

    public CreateProducts() {
        products = new ArrayList<>();
    }

    public List<T> getProducts() {
        setProductsToList();
        return products;
    }

    private void setProductsToList(){
        Milk milk = new Milk("MILK DANONE", "Almond", 32.2, 1.0);
        Milk milkGalychyna = new Milk("MILK GALYCHYNA", "Soy", 32.2, 1.0);
        Tea tea = new Tea("TEA GRIENFILD", "green", 17.1);
        Tea blackTea = new Tea("TEA MONARCH", "black", 34.0);
        Tea whiteTea = new Tea("TEA TIAN SCHAN", "white", 43.0);
        Fish hek = new Fish("FISH QUEEN HEK", "hek", 126.0, 3.0, true);
        Fish cambala = new Fish("FISH FLAGMAN", "cambala", 146.0, 2.7, false);
        Meat chicken = new Meat("MEAT RIABA", "chicken", 96.0, 3.0, true);
        Meat pig = new Meat("MEAT PIG", "pig", 120.9, 1.4, false);
        products.add((T) milk);
        products.add((T)milkGalychyna);
        products.add((T)tea);
        products.add((T)blackTea);
        products.add((T)whiteTea);
        products.add((T)hek);
        products.add((T)chicken);
        products.add((T)cambala);
        products.add((T)pig);
    }
}
