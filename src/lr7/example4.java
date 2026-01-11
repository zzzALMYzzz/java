package lr7;

class FirstClass {
    public char symbol;

    public FirstClass(char symbol) {
        this.symbol = symbol;
    }

    public FirstClass(FirstClass other) {
        this.symbol = other.symbol;
    }

    @Override
    public String toString() {
        return "FirstClass: " + ", Поле: '" + symbol + "'";
    }
}

class SecondClass extends FirstClass {
    public String text;

    public SecondClass(char symbol, String text) {
        super(symbol);
        this.text = text;
    }

    public SecondClass(SecondClass other) {
        super(other);
        this.text = other.text;
    }

    @Override
    public String toString() {
        return "SecondClass: " + ", Поле: '" + symbol + "'" + ", Поле: '" + text + "'";
    }
}

class ThirdClass extends SecondClass {
    public int number;

    public ThirdClass(char symbol, String text, int number) {
        super(symbol, text);
        this.number = number;
    }

    public ThirdClass(ThirdClass other) {
        super(other);
        this.number = other.number;
    }

    @Override
    public String toString() {
        return "ThirdClass: " + ", Поле: '" + symbol + "'" + ", Поле: '" + text + "'" + ", Поле: '" + number + "'";
    }
}

public class example4 {
    public static void main(String[] args) {
        FirstClass obj1 = new FirstClass('A');
        SecondClass obj2 = new SecondClass('B', "Привет");
        ThirdClass obj3 = new ThirdClass('C', "Мир", 42);

        System.out.println("Исходные объекты:");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        FirstClass copy1 = new FirstClass(obj1);
        SecondClass copy2 = new SecondClass(obj2);
        ThirdClass copy3 = new ThirdClass(obj3);

        System.out.println("Копии объектов:");
        System.out.println(copy1);
        System.out.println(copy2);
        System.out.println(copy3);

        obj3.symbol = 'X';
        obj3.text = "Изменён";
        obj3.number = 999;

        System.out.println("После изменения исходного obj3:");
        System.out.println("Исходный obj3: " + obj3);
        System.out.println("Копия copy3:  " + copy3);
    }
}
