package stack;

import products.Milk;

import java.util.ArrayList;

public class BlackList<T> {
    private ArrayList<Class> trueClasses = new ArrayList<>();
    //private Class<?> product;

    public BlackList() {
    }

    public ArrayList<Class> getTrueClasses() {
        //trueClasses.add(0,Milk); // - как тута добавить в Черный Список класс Milk ?
        return trueClasses;
    }

    public void setTrueClasses(ArrayList<Class> trueClasses) {
        this.trueClasses = trueClasses;
    }

    public static boolean check(Class<?> classAvaliableProduct) {
        // хочу тута проверить принадлежит ли
        // classAvaliableProduct классу из Черного Списка

        return true;
    }
}
