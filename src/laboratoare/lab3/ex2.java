package laboratoare.lab3;

import java.util.Scanner;

public class ex2 {
    static class Node {
        char litera;
        Node next;

        Node(char litera) {
            this.litera = litera;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = this;
            while (current != null) {
                sb.append(current.litera);

                if (current.next != null) {
                    sb.append("->");
                }
                current = current.next;
            }

            return sb.toString();
        }
    }

    static class ListaLitere {
        Node head;

        ListaLitere() {
            this.head = null;
        }

        void adauga(char litera) {
            Node nou = new Node(litera);

            if (head == null) {
                head = nou;
            } else {
                Node current = head;

                while (current.next != null) {
                    current = current.next;
                }
                current.next = nou;
            }
        }

        void afiseaza() {

            if (head == null) {
                System.out.println("Lista este goală");
                return;
            }

            System.out.println("Lista: " + head.toString());
        }

        boolean estePalindrom() {
            if (head == null || head.next == null) {
                return true;
            }

            int lungime = 0;
            Node current = head;
            while (current != null) {
                lungime++;
                current = current.next;
            }

            // Inversam jumate de lista
            Node prev = null;
            current = head;
            int count = 0;
            int jumatate = lungime / 2;

            while (count < jumatate) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            // Lucru cu imparitatea
            Node secondHalf = current;
            if (lungime % 2 != 0) {
                secondHalf = current.next;
            }

            Node firstHalf = prev;
            while (firstHalf != null && secondHalf != null) {
                if (firstHalf.litera != secondHalf.litera) {
                    return false;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return true;
        }

        String getCuvant() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.litera);
                current = current.next;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaLitere lista = new ListaLitere();

        System.out.println("Introduceți literele cuvântului (separate prin spațiu sau Enter):");
        System.out.println("Exemplu: a b c b a");
        String input = sc.nextLine().trim();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                lista.adauga(c);
            }
        }

        lista.afiseaza();

        String cuvant = lista.getCuvant();
        boolean palindrom = lista.estePalindrom();

        System.out.println("\nCuvântul format: " + cuvant);

        if (palindrom) {
            System.out.println("✓ Cuvântul este PALINDROM");
        } else {
            System.out.println("✗ Cuvântul NU este palindrom");
        }

        sc.close();
    }
}