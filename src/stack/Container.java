package stack;

import exception.CannotAddProductException;
import products.Product;

import java.util.List;

public class Container<T extends Product> {
    private List<T> elements;
    public Container() {
    }

    public void add(T element, boolean flag) throws CannotAddProductException {
        if (element == null) {
            throw new IllegalArgumentException("Product not found and can not add to Container.");
        }
        if (flag){
        addFirst(element);} else
            throw new CannotAddProductException("Can not add product from blackList");
    }

    public T getFirstAndRemove() {
        T result = elements.get(0);
        elements.remove(0);
        return result;
    }

    public T getFirst() {
        return elements.get(0);
    }

    public void addFirst(T element){
        elements.add(0,element);
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