package lr4;

import java.util.Scanner;

public class example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.print("Введите текст для шифрования: ");
        String sText = in.nextLine();
        
        System.out.print("Введите ключ: ");
        int iKey = in.nextInt();

        String sEncrypted = sCaesarTransform(sText, iKey);
        System.out.println("Текст после преобразования: " + sEncrypted);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String response = in.nextLine().trim();

            if (response.equalsIgnoreCase("y")) {
                String sDecrypted = sCaesarTransform(sEncrypted, -iKey);
                System.out.println("Текст после обратного преобразования: " + sDecrypted);
                break;
            } else if (response.equalsIgnoreCase("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        in.close();
    }

    public static String sCaesarTransform(String sText, int iKey) {
        StringBuilder result = new StringBuilder();
        for (char c : sText.toCharArray()) {
            result.append((char) (c + iKey));
        }
        return result.toString();
    }
}
