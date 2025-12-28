package lr5;

public class example6 {
    private int min;
    private int max;

    public example6(int... values) {
        if (values.length == 0) {
            this.min = 0;
            this.max = 0;
        } else if (values.length == 1) {
            this.min = values[0];
            this.max = values[0];
        } else {
            int a = values[0];
            int b = values.length > 1 ? values[1] : a;
            updateValues(a, b);
        }
    }

    public void setValues(int... args) {
        if (args.length == 1) {
            updateValues(args[0], args[0]);
        } else if (args.length >= 2) {
            updateValues(args[0], args[1]);
        }
    }

    private void updateValues(int val1, int val2) {
        int[] candidates = {val1, val2};
        int newMin = candidates[0];
        int newMax = candidates[0];

        for (int v : candidates) {
            if (v < newMin) newMin = v;
            if (v > newMax) newMax = v;
        }

        this.min = newMin;
        this.max = newMax;
    }

    public void display() {
        System.out.println("min = " + min + ", max = " + max);
    }

    public static void main(String[] args) {
        example6 obj = new example6(5, 10);
        obj.display();

        obj.setValues(7);
        obj.display();

        obj.setValues(3, 15);
        obj.display();

        obj.setValues(20);
        obj.display();
    }
}
