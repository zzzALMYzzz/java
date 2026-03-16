package lr9;

import java.util.HashMap;

public class example6 {  
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "нулевая строка");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        System.out.println("=== 1. Строки, где ключ > 5 ===");
        for (Integer key : map.keySet()) {
            if (key > 5) {
                System.out.println("Ключ: " + key + ", Строка: " + map.get(key));
            }
        }
        System.out.println("\n=== 2. Строка с ключом = 0 ===");
        if (map.containsKey(0)) {
            System.out.println(map.get(0));
        }
        System.out.println("\n=== 3. Перемножение ключей, где длина строки > 5 ===");
        long product = 1;
        boolean found = false;
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            if (value.length() > 5) {
                product *= key;
                found = true;
                System.out.println("Ключ " + key + " (\"" + value + "\") — длина: " + value.length());
            }
        }
        if (found) System.out.println("Произведение ключей: " + product);
        else System.out.println("Нет строк с длиной > 5.");
    }
}
