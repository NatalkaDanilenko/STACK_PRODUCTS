package products;

public class Fish implements Product {
    private String type;
    private double price;
    private double weight;
    private boolean frozen;
    private String name;

    public Fish() {
    }

    public Fish(String name, String type, double price, double weight, boolean frozen) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.frozen = frozen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type =" + type +
                '}';
    }
}
