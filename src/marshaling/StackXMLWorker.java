package marshaling;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import products.DictionaryProduct;
import products.Product;
import stack.Container;

public class StackXMLWorker {
    public static Container loadStackFromXMLFile(File file) {
        Container stack = new Container();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            NodeList products = root.getChildNodes();
            for (int i = 0; i < products.getLength(); i++) {
                Node node = products.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Product product = getProductFromNode(element);
                    if (product != null) {
                        stack.addFirst(product);
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return stack;
    }

    private static Product getProductFromNode(Element productTag) {
        if (!productTag.getTagName().equals("product")) {
            return null;
        }
        String tClass = productTag.getAttribute("type");//класс*
        // хочу в зависимости
        // от продукта возвращать только нужные атрибуты
        // типо для milk{name, typ, price, litr}

        String name = productTag.getElementsByTagName("name").item(0).getTextContent();
        String typ = productTag.getElementsByTagName("typ").item(0).getTextContent();
        double price = Double.valueOf(productTag.getElementsByTagName("price").item(0).getTextContent());
        double litr = Double.valueOf(productTag.getElementsByTagName("litr").item(0).getTextContent());
        String color = productTag.getElementsByTagName("color").item(0).getTextContent();
        double weight = Double.valueOf(productTag.getElementsByTagName("weight").item(0).getTextContent());
        boolean frozen = Boolean.valueOf(productTag.getElementsByTagName("frozen").item(0).getTextContent());
        // здеся как-то надо проверить какой же это класс* ?
        DictionaryProduct dict = new DictionaryProduct();
        Class classProduct = dict.getObjClass(tClass);

        //и тута соотв вместо Object - класс*



        Product product = (Product)myObject;//приводим класс* к Product ??
        return product;

    }

    public static Element elementFromProduct(Product product, Document document){
        Element productElement = document.createElement("product");

        DictionaryProduct dict = new DictionaryProduct(product);
        String tClass = dict.getObjType();
        productElement.setAttribute("type", tClass);
        Element name = document.createElement("name");
        name.setTextContent(product.getName());

    }
}
