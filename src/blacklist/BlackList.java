package blacklist;

import java.util.ArrayList;
import java.util.List;

public class BlackList {
    private List<Class> blackClasses;

    public BlackList() {
        blackClasses = new ArrayList<>();
    }

    public void setBlackClasses(Class classM) {
        blackClasses.add(classM);
    }

    public void getTrueClasses() {
        this.blackClasses = blackClasses;
    }

    public boolean check(Object obj) {
        return blackClasses.contains(obj.getClass());
    }

    @Override
    public String toString() {
        return blackClasses.toString();
    }
}
