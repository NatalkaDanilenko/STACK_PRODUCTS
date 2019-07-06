package stack;

import blacklist.BlackList;
import blacklist.CreateBlackList;
import exception.CannotAddProductException;
import marshaling.StackXMLWorker;
import products.*;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Container stack = new Container();
        BlackList black = new CreateBlackList().getBlackL();
        //StackXMLWorker.loadStackFromXMLFile(new File("/Users/nataliadanilenko/Documents/GIT/STACK_ELEMENTS/ProductsTEST.xml"));
        CreateProducts createProducts = new CreateProducts();
        List<Product> products = createProducts.getProducts();
        for (Product product : products) {
            try {
                stack.addNewProduct((Product) product, black.check(product));
            } catch (CannotAddProductException e) {
                System.out.println(" : " + product.getClass() + " " + ((Product) product).getName());
            }
        }

        StackXMLWorker.saveToXML(stack, new File("/Users/nataliadanilenko/Documents/GIT/STACK_ELEMENTS/ProductsTEST.xml"));

        /*BlackList black = new CreateBlackList().getBlackL();
        CreateProducts products = new CreateProducts();
        for (Object product : products.getProducts()) {
            try {
                stack.addNewProduct((Product) product, black.check(product));
            } catch (CannotAddProductException e) {
                System.out.println(" : " + product.getClass() + " " + ((Product) product).getName());
            }
        }*/




        StackXMLWorker.loadStackFromXMLFile("/Users/nataliadanilenko/Documents/GIT/STACK_ELEMENTS/Products.xml");

        System.out.println(stack.toString());

        //System.out.println("First product in stack " + stack.getFirst());

    }

}
