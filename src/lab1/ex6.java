package lab1;

import java.util.Scanner;

public class ex6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduceti numarul N: ");
        int n = sc.nextInt();
        
        System.out.print(n + " = ");
        descompunere(n, 2);
        
        sc.close();
    }
    
    static void descompunere(int n, int divizor) {
        if (n == 1) {
            return;
        }

        if (n % divizor == 0) {
            System.out.print(divizor);

            if (n / divizor != 1) {
                System.out.print("*");
            }

            descompunere(n / divizor, divizor);
        } else {

            descompunere(n, divizor + 1);
        }
    }
}
