package products;

public class Milk implements Product {
    private String name;
    private String type;
    private double price;
    private double litr;

    public Milk() {
    }

    public Milk(String name, String type, double price, double litr) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.litr = litr;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getLitr() {
        return litr;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type =" + type +
                ", price=" + price +
                ", litr=" + litr +
                '}';
    }
}
