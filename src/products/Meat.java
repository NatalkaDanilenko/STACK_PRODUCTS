package products;

public class Meat implements Product {
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
    public Class getType() {
        return Meat.class;
    }

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
}
