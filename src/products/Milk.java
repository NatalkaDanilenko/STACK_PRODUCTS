package products;

import java.util.HashMap;
import java.util.Map;

public class Milk implements Product {
    private final String TYPE = "milk";
    private String name;
    private String typ;
    private double price;
    private double litr;

    public Milk() {
    }

    public Milk(String name, String typ, double price, double litr) {
        this.name = name;
        this.typ = typ;
        this.price = price;
        this.litr = litr;
    }

    @Override
    public String getTYPE() {
        return TYPE;
    }

    @Override
    public void setTYPE(ExistProducts type) {
        type.toString();
    }

    public String getTyp() {
        return typ;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getLitr() {
        return litr;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLitr(double litr) {
        this.litr = litr;
    }

    @Override
    public String toString() {
        return "Fish {" +
                "name =" + name +
                ", typ =" + typ +
                ", price=" + price +
                ", litr=" + litr +
                '}';
    }

    @Override
    public Map<String, Object> toMap(Product product) {
        Map<String, Object> unicTags = new HashMap<>();
        Milk currentMilk = (Milk) product;
        unicTags.put("name", currentMilk.getName());
        unicTags.put("price", currentMilk.getPrice());
        unicTags.put("litr", currentMilk.getLitr());
        unicTags.put("typ", currentMilk.getTyp());
        return unicTags;
    }
}
