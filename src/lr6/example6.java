package lr6;

public class example6 {
    public static int[] getFirstElements(int[] original, int count) {
        if (original == null) {
            return null;
        }

        int length = Math.min(count, original.length);
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = original[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        int[] result1 = getFirstElements(array, 3);
        printArray(result1);

        int[] result2 = getFirstElements(array, 10);
        printArray(result2);

        int[] result3 = getFirstElements(array, 0);
        printArray(result3);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
