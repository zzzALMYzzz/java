package lr8;

import java.io.*;
import java.util.*;

public class example12 {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList(
            'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
            'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = null; 
        BufferedWriter bw = null; 
        try {
            br = new BufferedReader(new InputStreamReader(
            new FileInputStream("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\example12-1.txt")));
            bw = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("C:\\Users\\Sasha\\Desktop\\git_repos\\github\\java\\src\\lr8\\example12-2.txt")));

            String str;
            for(int lineCount = 1; (str = br.readLine()) != null; lineCount++) {
                String[] words = str.trim().split("\\s+");
                List<String> consonantWords = new ArrayList<>();
                for (String word : words) {
                    String cleanedWord = word.replaceAll("^[^\\p{L}]+|[^\\p{L}]+$", "");
                    if (!cleanedWord.isEmpty()) {
                        char firstChar = cleanedWord.charAt(0);
                        if (Character.isLetter(firstChar) && !VOWELS.contains(firstChar)) {
                            consonantWords.add(cleanedWord);
                        }
                    }
                }
                bw.write("Строка " + lineCount + ": найдено слов: " + consonantWords.size());
                if (!consonantWords.isEmpty()) {
                    bw.write(": " + String.join(" ", consonantWords));
                }
                bw.newLine();
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
