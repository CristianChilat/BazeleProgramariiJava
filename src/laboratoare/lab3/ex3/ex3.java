package laboratoare.lab3.ex3;

import java.io.*;
import java.util.Scanner;

public class ex3 {

    static class Node {
        int cifra;
        Node next;

        Node(int cifra) {
            this.cifra = cifra;
            this.next = null;
        }
    }

    static class NumarMare {
        Node head;

        void creeaza(String numar) {

            for (int i = numar.length() - 1; i >= 0; i--) {
                Node nou = new Node(numar.charAt(i) - '0');
                nou.next = head;
                head = nou;
            }
        }

        static NumarMare aduna(NumarMare a, NumarMare b) {
            NumarMare rezultat = new NumarMare();
            Node p1 = a.head, p2 = b.head;
            int transport = 0;
            Node tail = null;

            while (p1 != null || p2 != null || transport > 0) {
                int suma = transport;
                if (p1 != null) { suma += p1.cifra; p1 = p1.next; }
                if (p2 != null) { suma += p2.cifra; p2 = p2.next; }

                Node nou = new Node(suma % 10);

                if (rezultat.head == null) {
                    rezultat.head = tail = nou;
                } else {
                    tail.next = nou;
                    tail = nou;
                }
                transport = suma / 10;
            }

            return rezultat;
        }

        static NumarMare scade(NumarMare a, NumarMare b) {
            NumarMare rezultat = new NumarMare();
            Node p1 = a.head, p2 = b.head;
            int imprumut = 0;
            Node tail = null;

            while (p1 != null) {
                int dif = p1.cifra - imprumut;
                if (p2 != null) { dif -= p2.cifra; p2 = p2.next; }

                if (dif < 0) { dif += 10; imprumut = 1; }
                else { imprumut = 0; }

                Node nou = new Node(dif);

                if (rezultat.head == null) {
                    rezultat.head = tail = nou;
                } else {
                    tail.next = nou;
                    tail = nou;
                }
                p1 = p1.next;
            }

            return rezultat;
        }

        static NumarMare inmulteste(NumarMare a, NumarMare b) {
            NumarMare rezultat = new NumarMare();
            rezultat.head = new Node(0);

            Node p2 = b.head;
            int pozitie = 0;

            while (p2 != null) {
                NumarMare temp = new NumarMare();
                Node p1 = a.head;
                int transport = 0;
                Node tail = null;

                for (int i = 0; i < pozitie; i++) {
                    Node nou = new Node(0);

                    if (temp.head == null) {
                        temp.head = tail = nou;
                    } else {
                        tail.next = nou;
                        tail = nou;
                    }
                }

                while (p1 != null || transport > 0) {
                    int produs = transport;

                    if (p1 != null) {
                        produs += p1.cifra * p2.cifra; p1 = p1.next;
                    }

                    Node nou = new Node(produs % 10);

                    if (tail == null) {
                        temp.head = tail = nou;
                    } else {
                        tail.next = nou;
                        tail = nou;
                    }
                    transport = produs / 10;
                }

                rezultat = aduna(rezultat, temp);
                p2 = p2.next;
                pozitie++;
            }

            return rezultat;
        }

        static int compara(NumarMare a, NumarMare b) {
            int lenA = 0, lenB = 0;
            Node p = a.head;
            while (p != null) { lenA++; p = p.next; }
            p = b.head;
            while (p != null) { lenB++; p = p.next; }

            if (lenA != lenB) return lenA - lenB;

            return comparaRecursiv(a.head, b.head);
        }

        static int comparaRecursiv(Node a, Node b) {

            if (a == null) return 0;
            int comp = comparaRecursiv(a.next, b.next);

            if (comp != 0) return comp;
            return a.cifra - b.cifra;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curent = head;
            while (curent != null) {
                sb.append(curent.cifra);
                curent = curent.next;
            }
            return sb.toString();
        }
    }

    static void main(String[] args) {
        try {
            File fisier = new File("src/laboratoare/lab3/numere.txt");

            if (!fisier.exists()) {
                PrintWriter writer = new PrintWriter(fisier);
                writer.println("123456789012345678901234567890");
                writer.println("987654321098765432109876543210");
                writer.close();
                System.out.println("Fișier creat: numere.txt\n");
            }

            Scanner sc = new Scanner(fisier);
            String num1 = sc.nextLine().trim();
            String num2 = sc.nextLine().trim();
            sc.close();

            NumarMare n1 = new NumarMare();
            n1.creeaza(num1);
            NumarMare n2 = new NumarMare();
            n2.creeaza(num2);

            System.out.println("Număr 1: " + n1);
            System.out.println("Număr 2: " + n2);

            System.out.println("\nSuma: " + NumarMare.aduna(n1, n2));
            System.out.println("Diferența: " + NumarMare.scade(n1, n2));
            System.out.println("Produsul: " + NumarMare.inmulteste(n1, n2));

            int comp = NumarMare.compara(n1, n2);
            System.out.print("\nComparare: ");
            if (comp == 0) System.out.println("Numerele sunt egale");
            else if (comp > 0) System.out.println("Numărul 1 este mai mare");
            else System.out.println("Numărul 2 este mai mare");

        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}