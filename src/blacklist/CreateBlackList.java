package blacklist;

import products.Fish;
import products.Milk;

public class CreateBlackList {
    private BlackList blackL;

    public CreateBlackList() {
        blackL = new BlackList();
    }

    public BlackList getBlackL() {
        create();
        return blackL;
    }

    private void create() {
        blackL.setBlackClasses(Milk.class);
        blackL.setBlackClasses(Fish.class);
    }
}
