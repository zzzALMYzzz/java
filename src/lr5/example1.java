package lr5;

public class example1 {
    private char symbol;

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getCharCode() {
        return (int) symbol;
    }

    public void displaySymbolAndCode() {
        System.out.println("Символ: " + symbol + ", Код: " + getCharCode());
    }

    public static void main(String[] args) {
        example1 handler = new example1();
        handler.setSymbol('A');
        System.out.println("Код символа: " + handler.getCharCode());
        handler.displaySymbolAndCode();
    }
}
