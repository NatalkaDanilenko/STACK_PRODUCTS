package products;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.Map;

public interface Product {

    @NotNull
    public String getTYPE();

    public void setTYPE(ExistProducts type);

    @NotNull
    public Map<String, Object> toMap(Product product);

    public double getPrice();

    public void setPrice(double price);

    public String getName();

    public void setName(String name);

    @Nullable
    Product toProduct(Map<String, Object> product);
}
