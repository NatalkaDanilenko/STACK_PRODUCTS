package marshaling;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.sun.istack.internal.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import products.*;
import stack.Container;

public class StackXMLWorker {
    public static Container loadStackFromXMLFile(String file) {
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
        String type = productTag.getAttribute("type");//класс*
        // хочу в зависимости
        // от продукта возвращать только нужные атрибуты
        // типо для milk{name, typ, price, litr}

        Product product = createNewProduct(type);
        /*
        String name = productTag.getElementsByTagName("name").item(0).getTextContent();
        double price = Double.valueOf(productTag.getElementsByTagName("price").item(0).getTextContent());
        String typ = productTag.getElementsByTagName("typ").item(0).getTextContent();
        double litr = Double.valueOf(productTag.getElementsByTagName("litr").item(0).getTextContent());
        String color = productTag.getElementsByTagName("color").item(0).getTextContent();
        double weight = Double.valueOf(productTag.getElementsByTagName("weight").item(0).getTextContent());
        boolean frozen = Boolean.valueOf(productTag.getElementsByTagName("frozen").item(0).getTextContent());
        */
        Map<String, Object> unicTags = product.toMap(product);
        unicTags.forEach((key, value) -> value = productTag.getElementsByTagName(key).item(0).getTextContent());


        // здеся как-то надо проверить какой же это класс* ?
        /*DictionaryProduct dict = new DictionaryProduct();
        Class classProduct = dict.getObjClass(tClass);*/

        // Хочу продукт привести к новому классу и навтюхать ему необходимые параметры
        return product;

    }

    @Nullable
    private static Product createNewProduct(String type) {
        if (type.equals("milk")) {
            return new Milk();
        }

        if (type.equals("meat")) {
            return new Meat();
        }

        if (type.equals("tea")) {
            return new Tea();
        }

        if (type.equals("fish")) {
            return new Fish();
        }

        return null;
    }

    @Nullable
    public static Element elementFromProduct(Product product, Document document) {

        Element productElement = document.createElement("product");

        productElement.setAttribute("type", product.getTYPE());

        /*//общие для всех продуктов параметры
        Element name = document.createElement("name");
        name.setTextContent(product.getName());
        Element price = document.createElement("price");
        price.setTextContent(String.valueOf(product.getPrice()));
        */


        //параметры в зависимости от класса
        setContentByProduct(product, document, productElement);

        return productElement;
    }

    private static void setContentByProduct(Product product, Document document, Element productElement) {
        Set<Map.Entry<String, Object>> entrySet = product.toMap(product).entrySet();
        for (Map.Entry<String, Object> pair : entrySet) {
            Element element = document.createElement(pair.getKey());
            element.setTextContent(String.valueOf(pair.getValue()));
            productElement.appendChild(element);
        }
    }

    public static void saveToXML(Container stack, File fileName) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            Element root = document.createElement("products"); document.appendChild(root);
            for (Product product : (List<Product>)stack.getElements()) {
                Element productElem = elementFromProduct(product, document);
                root.appendChild(productElem);
            }

            TransformerFactory traF = TransformerFactory.newInstance();
            Transformer transformer = traF.newTransformer();

            DOMSource source = new DOMSource(document);

            StreamResult stRes = new StreamResult(fileName);

            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, stRes);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
