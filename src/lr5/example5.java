package lr5;

public class example5 {
    private int value;

    public example5() {
        this.value = 0;
    }

    public example5(int num) {
        setValue(num);
    }

    public void setValue() {
        this.value = 0;
    }

    public void setValue(int num) {
        if (num > 100) {
            this.value = 100;
        } else {
            this.value = num;
        }
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        example5 obj1 = new example5();
        example5 obj2 = new example5(150);
        example5 obj3 = new example5(75);

        System.out.println("obj1: " + obj1.getValue());
        obj1.setValue();
        System.out.println("obj1 setValue(): " + obj1.getValue());

        obj2.setValue(50);
        System.out.println("obj2: " + obj2.getValue());

        obj3.setValue(200);
        System.out.println("obj3: " + obj3.getValue());
    }
}
