package lab1;

import java.util.Scanner;

public class ex8 {
    static void main (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numarul N: ");
        int n = sc.nextInt();
        sc.close();

        System.out.println("Numarul de cifre este: " + nrDigits(n));
    }

    static int nrDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return 1 + nrDigits(n / 10);
    }
}
