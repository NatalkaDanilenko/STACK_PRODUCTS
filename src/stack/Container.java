package stack;

import com.sun.istack.internal.Nullable;
import exception.CannotAddProductException;
import products.Product;

import java.lang.reflect.Array;
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

    public T getFirstAndRemove() {
        T result = elements.get(0);
        elements.remove(0);
        return result;
    }

    public T getFirst() {
        return elements.get(0);
    }

    public ArrayList<T> addToStack(T element){
        ArrayList<T> newElements = new ArrayList<>(elements.size() + 1);
        newElements.add(0,element);
        for (int i = 0; i < newElements.size(); i++) {
            newElements.add(i+1, elements.get(i));
        }
        return newElements;
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