package lr10;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class example2_1 {
    private static final String FILE_PATH = "/test/products.xml";
    public static void main(String[] args) {
        try {
            File inputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Добавить продукт\n2. Найти продукт\n3. Удалить продукт");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(doc, scanner);
                    break;
                case 2:
                    searchProduct(doc, scanner);
                    break;
                case 3:
                    deleteProduct(doc, scanner);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
            saveXML(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(Document doc, Scanner scanner) {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        System.out.print("Введите категорию: ");
        String category = scanner.nextLine();
        System.out.print("Введите цену: ");
        String price = scanner.nextLine();

        Element rootElement = doc.getDocumentElement();
        Element newProduct = doc.createElement("product");

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        newProduct.appendChild(nameElement);

        Element categoryElement = doc.createElement("category");
        categoryElement.appendChild(doc.createTextNode(category));
        newProduct.appendChild(categoryElement);

        Element priceElement = doc.createElement("price");
        priceElement.appendChild(doc.createTextNode(price));
        newProduct.appendChild(priceElement);

        rootElement.appendChild(newProduct);
        System.out.println("Продукт добавлен.");
    }

    private static void searchProduct(Document doc, Scanner scanner) {
        System.out.print("Введите категорию для поиска: ");
        String searchCategory = scanner.nextLine();

        NodeList nodeList = doc.getElementsByTagName("product");
        boolean found = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String category = element.getElementsByTagName("category").item(0).getTextContent();
                if (category.equalsIgnoreCase(searchCategory)) {
                    System.out.println("Найдено: " + element.getElementsByTagName("name").item(0).getTextContent() +
                            " - " + element.getElementsByTagName("price").item(0).getTextContent() + " руб.");
                    found = true;
                }
            }
        }
        if (!found) System.out.println("Продукты не найдены.");
    }

    private static void deleteProduct(Document doc, Scanner scanner) {
        System.out.print("Введите название продукта для удаления: ");
        String targetName = scanner.nextLine();

        NodeList nodeList = doc.getElementsByTagName("product");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                if (name.equalsIgnoreCase(targetName)) {
                    node.getParentNode().removeChild(node);
                    System.out.println("Продукт удален.");
                    return;
                }
            }
        }
        System.out.println("Продукт не найден.");
    }

    private static void saveXML(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}