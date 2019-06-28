package stack;

import exception.CannotAddProductException;
import products.*;

public class Main {
    public static void main(String[] args) {
        Container stack = new Container();
        Milk milk = new Milk("MILK DANONE","Almond", 32.20, 1.0);
        Tea tea = new Tea("TEA GRIENFILD", "green", 17.10);
        Fish cambala = new Fish("FISH FLAGMAN", "cambala", 146.0, 2.7, false);
        Meat chicken = new Meat("MEAT RIABA", "chicken", 96.0, 3.0, true);

        BlackList black = new CreateBlackList().getBlackL();
        try {
            stack.add(milk,black.check(milk));
            stack.add(tea,black.check(tea));
            stack.add(cambala,black.check(cambala));
            stack.add(chicken,black.check(chicken));
        } catch (CannotAddProductException e) {
            e.printStackTrace();
        }
        System.out.println(stack.toString());

    }

}
