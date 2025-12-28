package lr5;

public class example4 {
    private char symbol;
    private int number;

    public example4(int num, char sym) {
        this.number = num;
        this.symbol = sym;
    }

    public example4(double value) {
        this.symbol = (char) ((int) value);

        int fractional = (int) ((value - (int) value) * 100);
        this.number = Math.abs(fractional);
    }

    public void display() {
        System.out.println("Символ: '" + symbol + "', Целое число: " + number);
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        example4 sn1 = new example4(100, 'X');
        sn1.display();

        example4 sn2 = new example4(65.1267);
        sn2.display();

        example4 sn3 = new example4(97.459);
        sn3.display();
    }
}
