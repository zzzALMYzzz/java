package lr10;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class example1_6 {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();

            Elements newsParent = doc.select("body > table > tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > tr:nth-child(1)");

            for (int i = 0; i < 10; i++) {
                List<Node> nodes = newsParent.get(0).childNodes();
                System.out.println("Тема : " +
                        ((Element) nodes.get(1))
                                .getElementsByClass("blocktitle")
                                .get(0));

                System.out.println("Дата : " +
                        ((Element) nodes.get(1))
                                .getElementsByClass("blockdate")
                                .get(0).childNodes()
                                .get(0) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
