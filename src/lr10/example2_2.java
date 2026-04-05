package lr10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class example2_2 {
    private static final String FILE_PATH = "/test/products.json";
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(FILE_PATH));
            JSONArray productsArray = (JSONArray) jsonObject.get("products");

            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Добавить продукт\n2. Найти продукт\n3. Удалить продукт");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(productsArray, scanner);
                    break;
                case 2:
                    searchProduct(productsArray, scanner);
                    break;
                case 3:
                    deleteProduct(productsArray, scanner);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }

            try (FileWriter file = new FileWriter(FILE_PATH)) {
                file.write(jsonObject.toJSONString());
                file.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(JSONArray array, Scanner scanner) {
        JSONObject newProduct = new JSONObject();
        System.out.print("Введите название: ");
        newProduct.put("name", scanner.nextLine());
        System.out.print("Введите категорию: ");
        newProduct.put("category", scanner.nextLine());
        System.out.print("Введите цену: ");
        newProduct.put("price", scanner.nextInt());

        array.add(newProduct);
        System.out.println("Продукт добавлен.");
    }

    private static void searchProduct(JSONArray array, Scanner scanner) {
        System.out.print("Введите категорию для поиска: ");
        String targetCategory = scanner.nextLine();

        array.stream()
            .filter(item -> item instanceof JSONObject)
            .map(item -> (JSONObject) item)
            .filter(product -> targetCategory.equalsIgnoreCase((String) product.get("category")))
            .forEach(product -> {
                System.out.println("Найдено: " + product.get("name") + " - " + product.get("price") + " руб.");
            });
    }

    private static void deleteProduct(JSONArray array, Scanner scanner) {
        System.out.print("Введите название для удаления: ");
        String targetName = scanner.nextLine();

        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            JSONObject product = (JSONObject) iterator.next();
            if (targetName.equalsIgnoreCase((String) product.get("name"))) {
                iterator.remove();
                System.out.println("Продукт удален.");
                return;
            }
        }
        System.out.println("Продукт не найден.");
    }
}