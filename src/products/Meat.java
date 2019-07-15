package products;

import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Meat implements Product {
    private final String TYPE = "meat";
    private String typ;
    private double price;
    private double weight;
    private boolean frozen;
    private String name;

    public Meat() {
    }

    public Meat(String name, String typ, double price, double weight, boolean frozen) {
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
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
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
        return "Meat {" +
                "name =" + name +
                ", price =" + price +
                ", weight =" + weight +
                ", frozen =" + frozen +
                ", typ =" + typ +
                '}';
    }

    @Override
    public Map<String,Object> toMap(Product product) {
        Map<String, Object> unicTags = new HashMap<>();
        Meat currentMeat = (Meat) product;
        unicTags.put("name", currentMeat.getName());
        unicTags.put("price", currentMeat.getPrice());
        unicTags.put("frozen", currentMeat.isFrozen());
        unicTags.put("typ", currentMeat.getTyp());
        unicTags.put("weight", currentMeat.getWeight());
        return unicTags;
    }

    @Override
    @Nullable
    public Product toProduct(Map<String, Object> product) {
        if (product == null){
            return null;
        }
        return new Meat((String) product.get("name"),
                (String) product.get("typ"),
                (Double) product.get("price"),
                (Double) product.get("weight"),
                (Boolean) product.get("frozen"));
    }
}
