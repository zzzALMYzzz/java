package timus.task_1785;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int N = in.nextInt();

        if (N >= 1 && N <= 4) {
            System.out.println("few");
        } else if (N >= 5 && N <= 9) {
            System.out.println("several");
        } else if (N >= 10 && N <= 19) {
            System.out.println("pack");
        } else if (N >= 20 && N <= 49) {
            System.out.println("lots");
        } else if (N >= 50 && N <= 99) {
            System.out.println("horde");
        } else if (N >= 100 && N <= 249) {
            System.out.println("throng");
        } else if (N >= 250 && N <= 499) {
            System.out.println("swarm");
        } else if (N >= 500 && N <= 999) {
            System.out.println("zounds");
        } else if (N >= 1000 && N <= 2000) {
            System.out.println("legion");
        } else {
            System.out.println("Ошибка: число должно быть больше нуля и меньше двух тысяч");
        }

        in.close();
    }  
}
