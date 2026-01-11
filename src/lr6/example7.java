package lr6;

public class example7 {
    public static int[] convertToCodeArray(char[] chars) {
        if (chars == null) {
            return null;
        }
        int[] codes = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            codes[i] = (int) chars[i];
        }
        return codes;
    }

    public static void main(String[] args) {
        char[] symbols = {'H', 'e', 'l', 'l', 'o', ' ', 'М', 'и', 'р'};
        int[] codes = convertToCodeArray(symbols);

        for (int code : codes) {
            System.out.print(code + " ");
        }
    }
}
