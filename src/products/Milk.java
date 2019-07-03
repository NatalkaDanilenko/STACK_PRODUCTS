package products;

public class Milk implements Product {
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

    public String getTyp() {
        return typ;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class getType() {
        return Milk.class;
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
}
