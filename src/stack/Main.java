package stack;

import exception.CannotAddProductException;
import products.*;

public class Main {
    public static void main(String[] args) {
        Container stack = new Container();
        BlackList black = new CreateBlackList().getBlackL();
        CreateProducts products = new CreateProducts();
        for (Object product : products.getProducts()) {
            try {
                stack.add((Product) product, black.check(product));
            } catch (CannotAddProductException e) {
                System.out.println(" : " + product.getClass() + " " + ((Product) product).getName());
            }
        }
        System.out.println(stack.toString());

        System.out.println("First product in stack " + stack.getFirst());

    }

}
