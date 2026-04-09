package laboratoare.lab1;

import java.util.Scanner;

public class ex3 {
    static void main() {
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number from 1 to ...: ");
        n = sc.nextInt();
        
        int suma = sir(n);
        System.out.println("S(" + n + ") = " + suma);
        
        sc.close();
    }

    static int sir(int n) {
        return n == 1 ? 1 : sir(n - 1) + (2 * n - 1);
    }
}
