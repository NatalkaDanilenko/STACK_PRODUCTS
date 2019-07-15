package products;

import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Tea implements Product {
    private final String TYPE = "tea";
    private String name;
    private String color;
    private double price;

    public Tea() {
    }

    public Tea(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    @Override
    public String getTYPE() {
        return TYPE;
    }

    @Override
    public void setTYPE(ExistProducts type) {
        type.toString();
    }

    public String getColor() {
        return color;
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

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tea {" +
                "name =" + name +
                ", color =" + color +
                ", price =" + price +
                '}';
    }

    @Override
    public Map<String, Object> toMap(Product product) {
        Map<String, Object> unicTags = new HashMap<>();
        Tea currentTea = (Tea) product;
        unicTags.put("name", currentTea.getName());
        unicTags.put("price", currentTea.getPrice());
        unicTags.put("color", currentTea.getColor());
        return unicTags;
    }

    @Override
    @Nullable
    public Product toProduct(Map<String, Object> product) {
        if (product == null){
            return null;
        }
        return new Tea((String) product.get("name"),
                (String) product.get("color"),
                (Double) product.get("price"));
    }
}
