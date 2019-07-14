package products;

import java.util.HashMap;
import java.util.Map;

public class Fish implements Product {
    private static final String TYPE = "fish";
    private String typ;
    private double price;
    private double weight;
    private boolean frozen;
    private String name;

    public Fish() {
    }

    public Fish(String name, String typ, double price, double weight, boolean frozen) {
        this.name = name;
        this.typ = typ;
        this.price = price;
        this.weight = weight;
        this.frozen = frozen;
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

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Object> toMap(Product product) {
        Map<String, Object> unicTags = new HashMap<>();
        Fish currentFish = (Fish) product;
        unicTags.put("name", currentFish.getName());
        unicTags.put("price", currentFish.getPrice());
        unicTags.put("weight", currentFish.getWeight());
        unicTags.put("typ", currentFish.getTyp());
        unicTags.put("frozen", currentFish.isFrozen());
        return unicTags;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public String toString() {
        return "Fish {" +
                "name =" + name +
                ", price =" + price +
                ", weight =" + weight +
                ", frozen =" + frozen +
                ", typ =" + typ +
                '}';
    }
}
