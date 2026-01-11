package lr8;

import java.io.*;

public class example1 {
    public static void main(String[] args) {
        try {
            File f1 = new File("MyFile1.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!!!!");
                System.out.println("Полный путь 1:	" + f1.getAbsolutePath());
            }

            File f2=new File("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\MyFile2.txt"); 
            f2.createNewFile();
            if (f2.exists()) {
                System.out.println("Создан!!!!");
                System.out.println("Полный путь 2:	" + f2.getAbsolutePath());
            }

            File f3 = new File("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\Papka1\\Papka2\\Papka3"); 
            f3.mkdirs();
            if (f3.exists()) {
                System.out.println("Создан!!!!");
                System.out.println("Полный путь 3:	" + f3.getAbsolutePath());
            }

        } catch (Exception e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
