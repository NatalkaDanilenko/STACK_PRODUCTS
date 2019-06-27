package stack;

import com.sun.istack.internal.Nullable;
import exception.CannotAddProductException;
import products.Product;

import java.util.ArrayList;

public class Container<T extends Product> {
    private ArrayList<T> elements = new ArrayList<>();
    public Container() {
    }

    public void add(T element, boolean flag) throws CannotAddProductException {
        if (element == null) {
            throw new IllegalArgumentException("Product not found and can not add to Container.");
        }
        if (flag){
        elements.add(element);} else
            throw new CannotAddProductException("Can not add product from blackList");
    }

    @Nullable
    public T getAndRemove(T element) {
        T result = null;
        for (T product : elements) {
            if (product.equals(element)) {
                result = product;
                elements.remove(product);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : elements) {
            sb.append(product).append(System.lineSeparator());
        }
        return sb.toString();
    }
}