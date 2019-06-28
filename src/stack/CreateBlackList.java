package stack;

import products.Fish;
import products.Milk;

public class CreateBlackList {
    private BlackList blackL;
    private Milk milk;
    private Fish fish;

    public CreateBlackList() {
    }

    public BlackList getBlackL() {
        create();
        return blackL;
    }

    private void create(){
        blackL.setTrueClasses(milk.getClass());
        blackL.setTrueClasses(fish.getClass());
    }
}
