package lr5;

public class example2 {
    private char char1;
    private char char2;

    public example2(char char1, char char2) {
        this.char1 = char1;
        this.char2 = char2;
    }

    public void printRange() {
        char start = char1;
        char end = char2;

        for (char c = start; c <= end; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public char getChar1() {
        return char1;
    }

    public void setChar1(char char1) {
        this.char1 = char1;
    }

    public char getChar2() {
        return char2;
    }

    public void setChar2(char char2) {
        this.char2 = char2;
    }

    public static void main(String[] args) {
        example2 obj = new example2('A', 'D');
        obj.printRange();
    }
}
