package products;

public class Fish implements Product {
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
