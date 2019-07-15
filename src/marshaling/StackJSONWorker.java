package marshaling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.istack.internal.Nullable;
import products.Product;
import stack.Container;

import static marshaling.StackXMLWorker.createNewProduct;

public class StackJSONWorker {
    public static void saveToJSONFile(Container stack, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Map<String, Object>> map = new HashMap<>();
        List<Map<String, Object>> listProduct = new ArrayList<>();
        for (Product product : (List<Product>) stack.getElements()) {
            Map<String, Object> currentProduct = new HashMap<>();
            currentProduct.put("-type", product.getTYPE());
            currentProduct.putAll(product.toMap(product));
            listProduct.add(currentProduct);
        }
        Map<String, Object> newMap = new HashMap<>();
        newMap.put("product", listProduct);
        map.put("products", newMap);
        String gsonSt = gson.toJson(map);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(gsonSt);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Nullable
    public static Container loadFromJSON(File file) {
        Container stack = new Container();
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        //Product product = null;
        try {
            map = gson.fromJson(new FileReader(file), new TypeToken<Map<String, Object>>() {
            }.getType());
            Map<String, Object> readProduct = (Map<String, Object>) map.get("products");
            List<Product> listProduct = getEachProduct(readProduct);
            for (Product product : listProduct) {
                stack.addFirst(product);
            }

        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return stack;
    }

    @Nullable
    private static List<Product> getEachProduct(Map<String, Object> readProduct) {
        List<Product> listProduct = new ArrayList<>();
        List<Map<String, Object>> products = (List<Map<String, Object>>) readProduct.get("product");
        for (Map<String, Object> product : products) {
            String type = (String) product.get("-type");
            Product eachProduct = createNewProduct(type);
            if (eachProduct != null) {
                Map<String, Object> unicTags = eachProduct.toMap(eachProduct);
                unicTags.forEach((key, value) -> value = product.get(key));
                if (eachProduct != null) {
                    listProduct.add(eachProduct);
                }
            }
        }
        return listProduct;
    }
}
