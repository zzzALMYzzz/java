package lr6;

public class example1 {
    private char charField;
    private String textField;

    public void setValue(char c) {
        this.charField = c;
    }

    public void setValue(String text) {
        this.textField = text;
    }

    public void setValue(char[] arr) {
        if (arr == null || arr.length == 0) {
            this.textField = "";
        } else if (arr.length == 1) {
            this.charField = arr[0];
        } else {
            this.textField = new String(arr);
        }
    }

    public char getCharField() {
        return charField;
    }

    public String getTextField() {
        return textField;
    }

    public static void main(String[] args) {
        example1 obj = new example1();

        obj.setValue('A');
        System.out.println("charField = " + obj.getCharField());

        obj.setValue("Hello");
        System.out.println("textField = " + obj.getTextField());

        obj.setValue(new char[]{'X'});
        System.out.println("charField = " + obj.getCharField());

        obj.setValue(new char[]{'H', 'i'});
        System.out.println("textField = " + obj.getTextField());
    }
}
