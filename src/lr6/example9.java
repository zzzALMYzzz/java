package lr6;

public class example9 {
    public static void swapPairs(char[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};

        System.out.println("До обмена: " + new String(chars));
        swapPairs(chars);
        System.out.println("После обмена: " + new String(chars));
    }
}
