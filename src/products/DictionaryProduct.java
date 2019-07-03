package products;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DictionaryProduct {
    private Product product;
    private Map<Class, String> objType = new HashMap<>();

    public DictionaryProduct() {
    }

    public DictionaryProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setObjType(Map<Class, String> objType) {
        this.objType = objType;
    }

    private void createMap(){
        objType.put(Milk.class, "milk");
        objType.put(Tea.class, "tea");
        objType.put(Fish.class, "fish");
        objType.put(Meat.class, "meat");
    }

    public String getObjType(){
        return objType.get(product.getClass());
    }

    public Class getObjClass(String tClass){
        Set<Map.Entry<Class,String>> entrySet=objType.entrySet();
        for (Map.Entry<Class,String> pair : entrySet) {
            if (tClass.equals(pair.getValue())) {
                return pair.getKey();
            }
        }

    }
}
