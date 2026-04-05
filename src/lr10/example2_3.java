package lr10;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class example2_3 {
    public static void main(String[] args) {
        String url = "http://fat.urfu.ru/index.html";
        Document doc = null;
        int maxRetries = 3;
        int currentAttempt = 0;
        boolean connected = false;

        while (currentAttempt < maxRetries && !connected) {
            try {
                System.out.println("Попытка подключения " + (currentAttempt + 1) + " из " + maxRetries);
                doc = Jsoup.connect(url).get();
                connected = true;
            } catch (IOException e) {
                currentAttempt++;
                System.err.println("Ошибка при получении HTML-кода: " + e.getMessage());
                if (currentAttempt < maxRetries) {
                    System.out.println("Повторное подключение через 2 секунды...");
                    try { Thread.sleep(2000); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
                } else {
                    System.err.println("Не удалось подключиться после " + maxRetries + " попыток.");
                    return;
                }
            }
        }

        if (doc != null) {
            Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > " +
                    "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                    "tr > td:nth-child(1)");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("/test/parsed_news.txt"))) {
                for (int i = 3; i < 20; i++) {
                    if (!(i % 2 == 0)) {
                        List<Node> nodes = newsParent.get(0).childNodes();
                        
                        String title = ((Element) nodes.get(i))
                                .getElementsByClass("blocktitle")
                                .get(0).childNodes().get(0).toString();
                        
                        String date = ((Element) nodes.get(i))
                                .getElementsByClass("blockdate")
                                .get(0).childNodes().get(0).toString();

                        String formattedNews = "Тема : " + title + "\nДата : " + date + "\n";
                        
                        // Вывод в консоль и запись в файл
                        System.out.println(formattedNews);
                        writer.write(formattedNews);
                        writer.newLine();
                    }
                }
                System.out.println("Новости успешно сохранены в файл 'parsed_news.txt'.");
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Ошибка структуры HTML-страницы: не удалось найти требуемые элементы.");
            }
        }
    }
}