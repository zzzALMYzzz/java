package lr7;

class FirstClass {
    public int number;

    public FirstClass(int number) {
        this.number = number;
    }

    public void setValues(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FirstClass: " + ", Поле: '" + number + "'";
    }
}

class SecondClass extends FirstClass {
    public char symbol;

    public SecondClass(int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    public void setValues(int number, char symbol) {
        super.setValues(number);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "SecondClass: " + ", Поле: '" + number + "'" + ", Поле: '" + symbol + "'";
    }
}

class ThirdClass extends SecondClass {
    public String text;

    public ThirdClass(int number, char symbol, String text) {
        super(number, symbol);
        this.text = text;
    }

    public void setValues(int number, char symbol, String text) {
        super.setValues(number, symbol);
        this.text = text;
    }

    @Override
    public String toString() {
        return "ThirdClass: " + ", Поле: '" + number + "'" + ", Поле: '" + symbol + "'" + ", Поле: '" + text + "'";
    }
}

public class example3 {
    public static void main(String[] args) {
        FirstClass obj1 = new FirstClass(10);
        SecondClass obj2 = new SecondClass(20, 'X');
        ThirdClass obj3 = new ThirdClass(30, 'Y', "Hello");

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        obj1.setValues(100);
        System.out.println("После изменения obj1: " + obj1);

        obj2.setValues(200, 'Z');
        System.out.println("После изменения obj2: " + obj2);

        obj3.setValues(300, 'W', "World");
        System.out.println("После изменения obj3: " + obj3);
    }
}
