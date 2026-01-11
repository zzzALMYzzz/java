package lr7;

class SuperClass {
    private String text;

    public SuperClass(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextLength() {
        return text != null ? text.length() : 0;
    }

    @Override
    public String toString() {
        return "СуперКласс: " + this.getClass().getSimpleName() + ", Поле: '" + text + "'";
    }
}

class SubClass extends SuperClass {
    public int number;

    public SubClass(String text, int number) {
        super(text);
        this.number = number;
    }

    public void setValues() {
        setText("default");
        this.number = 0;
    }

    public void setValues(String text) {
        setText(text);
    }

    public void setValues(int number) {
        this.number = number;
    }

    public void setValues(String text, int number) {
        setText(text);
        this.number = number;
    }

    @Override
    public String toString() {
        return "ПодКласс: " + this.getClass().getSimpleName() + ", Первое поле: '" + super.toString().split(",")[1].trim() + "'" + ", Второе поле: '" + number + "'";
    }
}

public class example2 {
    public static void main(String[] args) {
        SuperClass superObj = new SuperClass("Привет из SuperClass");
        System.out.println(superObj);
        System.out.println("Длина текста: " + superObj.getTextLength());

        SubClass subObj = new SubClass("Привет", 42);
        System.out.println(subObj);

        subObj.setValues();
        System.out.println("После setValues(): " + subObj);

        subObj.setValues("Новый текст");
        System.out.println("После setValues(String): " + subObj);

        subObj.setValues(100);
        System.out.println("После setValues(int): " + subObj);

        subObj.setValues("Финальный текст", 999);
        System.out.println("После setValues(String, int): " + subObj);
    }
}
