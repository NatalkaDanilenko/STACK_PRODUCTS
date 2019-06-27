package stack;

import exception.CannotAddProductException;
import products.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Container stack = new Container();
        Milk milk = new Milk("MILK DANONE","Almond", 32.20, 1.0);
        Tea tea = new Tea("TEA GRIENFILD", "green", 17.10);
        Fish cambala = new Fish("FISH FLAGMAN", "cambala", 146.0, 2.7, false);
        Meat chicken = new Meat("MEAT RIABA", "chicken", 96.0, 3.0, true);



    }

}
