package lr8;

import java.io.*;

public class example11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null; 
        BufferedWriter bw = null; 
        try {
            br = new BufferedReader(new InputStreamReader(
            new FileInputStream("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\example11-1.txt"),"cp1251"));
            bw = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\example11-2.txt"),"cp1251"));

            String str;
            for(int lineCount = 0; (str = br.readLine()) != null; lineCount++) {
                try {
                    double value = Double.parseDouble(str);
                    if(value > 0.0) {
                        System.out.println(lineCount + ": " + str);
                        bw.write(str);
                        bw.newLine();
                    }
                } catch (NumberFormatException e) {}
                if(lineCount == 1) {
                    System.out.println(lineCount + ": " + str);
                    bw.write(str);
                    bw.newLine();
                }
            }
        } catch (IOException e) { 
            System.out.println("Ошибка!!!!!!!!");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
