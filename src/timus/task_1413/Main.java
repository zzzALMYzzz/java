package timus.task_1413;

import java.io.IOException;

public class Main {  
    public static void main(String[] args) throws IOException {
        double x = 0;
        double y = 0;
        final double DIAG = Math.sqrt(2) / 2.0;

        while (true) {
            int code = System.in.read();
            if (code == -1 || code == '\n' || code == '\r') {
                break;
            }
            
            char ch = (char) code;

            if (ch == '0') {
                break;
            }

            switch (ch) {
                case '1': x -= DIAG; y -= DIAG; break;
                case '2':          y -= 1.0;  break;
                case '3': x += DIAG; y -= DIAG; break;
                case '4': x -= 1.0;           break;
                case '5': break;
                case '6': x += 1.0;           break;
                case '7': x -= DIAG; y += DIAG; break;
                case '8':          y += 1.0;  break;
                case '9': x += DIAG; y += DIAG; break;
                default: break;
            }
        }
        System.out.printf("%.10f %.10f\n", x, y);
    }  
}
