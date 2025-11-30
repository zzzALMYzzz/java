package lr1;

public class example3 {  
    public static void main(String[] args) {
        int iNum_1 = 50;
        int iNum_2 = 100;
        if( iNum_1 < iNum_2 ) {
            System.out.println(iNum_1 + " < " + iNum_2);
        }
        iNum_1 = iNum_1 * 2;
        if( iNum_1 == iNum_2 ) {
            System.out.println(iNum_1 + " = " + iNum_2);
        }
        iNum_1 = iNum_1 * iNum_2;
        if( iNum_1 > iNum_2 ) {
            System.out.println(iNum_1 + " > " + iNum_2);
        }
    }  
}