package stack;

import java.util.ArrayList;
import java.util.List;

public class BlackList {
    private List<Class> trueClasses;

    public BlackList() {
        trueClasses = new ArrayList<>();
    }

    public void setTrueClasses(Class classM) {
        trueClasses.add(classM);
    }

    public void getTrueClasses() {
        this.trueClasses = trueClasses;
    }

    public boolean check(Object obj) {
        return trueClasses.contains(obj.getClass());
    }
}
