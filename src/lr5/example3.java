package lr5;

public class example3 {
    private int field1;
    private int field2;

    public example3() {
        this.field1 = 0;
        this.field2 = 0;
    }

    public example3(int value) {
        this.field1 = value;
        this.field2 = 0;
    }

    public example3(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public void display() {
        System.out.println("field1: " + field1 + ", field2: " + field2);
    }

    public static void main(String[] args) {
        example3 obj1 = new example3();
        example3 obj2 = new example3(5);
        example3 obj3 = new example3(3, 7);

        obj1.display();
        obj2.display();
        obj3.display();
    }
}
