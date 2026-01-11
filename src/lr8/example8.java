package lr8;

import java.io.*;
import java.net.*;

public class example8 {
    public static void readAllByByte(Reader in) throws IOException { 
        while (true) {
            int oneByte = in.read();	// читает 1 байт
            if (oneByte != -1) {	// признак конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + " конец ");
                break;
            }
        }
    }
 
    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile	= new FileInputStream("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\MyFile1.txt");	// байтовый
            Reader rFile= new InputStreamReader(inFile,"cp1251");	// символьный
            readAllByByte(rFile); 
            System.out.print("\n\n\n"); 
            inFile.close();
            rFile.close();

            // С потоком связана интернет-страница передается	«русская» кодировка
            InputStream inUrl = new URL("http://google.com").openStream(); // байтовый
            Reader rUrl = new InputStreamReader(inUrl,  "cp1251");	// символьный
            readAllByByte(rUrl); System.out.print("\n\n\n"); 
            inUrl.close();
            rUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[] {5, 8, 3, 9, 11}); 
            Reader rArray = new InputStreamReader(inArray,"cp1251" ); // символьный
            readAllByByte(rArray); 
            System.out.print("\n\n\n"); 
            inArray.close(); 
            rArray.close();
        } catch (IOException e) { 
            System.out.println("Ошибка: "+ e);
        }
    }
}
