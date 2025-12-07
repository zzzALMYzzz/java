package lr3;

public class example7 {
    public static void main(String[] args) {
        int iSize = 10;
        char[] iArray = new char[iSize];
        char iCurrent = 'а';

        for (int i = 0; i < iSize; i++) {
            iArray[i] = iCurrent;
            iCurrent += 2;
        }

        System.out.print("Прямой порядок: ");
        for (int i = 0; i < iArray.length; i++) {
            System.out.print(iArray[i] + " ");
        }
        
        System.out.println();

        System.out.print("Обратный порядок: ");
        for (int i = iArray.length - 1; i >= 0; i--) {
            System.out.print(iArray[i] + " ");
        }
    }
}
