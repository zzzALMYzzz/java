package lr10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class example1_1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);
            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);
            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Баран да Муха"));
            book1.appendChild(title1);
            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Иван Крылов"));
            book1.appendChild(author1);
            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1808"));
            book1.appendChild(year1);
            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);
            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);
            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Михаил Булгаков"));
            book2.appendChild(author2);
            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1977"));
            book2.appendChild(year2);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/test/example.xml"));
            transformer.transform(source, result);
            System.out.println("XML-файл успешно создан!");
        } catch (Exception pce) {
            pce.printStackTrace();
        }
    }
}
