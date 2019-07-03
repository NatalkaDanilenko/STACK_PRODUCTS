package products;

public class Tea implements Product {
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

    public String getColor() {
        return color;
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
}
