package lr3;

public class example8 {
    public static void main(String[] args) {
        int iSize = 10;
        char[] iArray = new char[iSize];

        String iVowels = "AEIOU";
        char iCurrent = 'B';
        int iCount = 0;

        while (iCount < iSize) {
            if (iVowels.indexOf(iCurrent) == -1) {
                iArray[iCount] = iCurrent;
                iCount++;
            }
            iCurrent++;
        }

        System.out.print("Массив согласных: ");
        for (int i = 0; i < iArray.length; i++) {
            System.out.print(iArray[i] + " ");
        }
    }
}
