package lr7;

class SuperClass {
    private String text;

    public SuperClass(String text) {
        this.text = text;
    }

    protected String getText() {
        return text;
    }

    public void display() {
        System.out.println("СуперКласс: '" + this.getClass().getSimpleName() + "', Поле: '" + text + "'");
    }
}

class SubClass1 extends SuperClass {
    protected int number;

    public SubClass1(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void display() {
        System.out.println("ПодКласс 1: '" + this.getClass().getSimpleName() + "', Поле: '" + getText() + "', Поле: '" + number + "'");
    }
}

class SubClass2 extends SuperClass {
    protected char symbol;

    public SubClass2(String text, char symbol) {
        super(text);
        this.symbol = symbol;
    }

    @Override
    public void display() {
        System.out.println("ПодКласс 2: '" + this.getClass().getSimpleName() + "', Поле: '" + getText() + "', Поле: '" + symbol + "'");
    }
}

public class example5 {
    public static void main(String[] args) {
        SuperClass superObj = new SuperClass("Текст суперкласса");
        SubClass1 subObj1 = new SubClass1("Текст подкласса 1", 42);
        SubClass2 subObj2 = new SubClass2("Текст подкласса 2", 'X');

        System.out.println("Вызов метода display() для каждого объекта:");
        superObj.display();
        subObj1.display();
        subObj2.display();

        System.out.println("Вызов метода display() через переменную суперкласса:");

        SuperClass ref1 = subObj1;
        SuperClass ref2 = subObj2;

        ref1.display();
        ref2.display();
    }
}
