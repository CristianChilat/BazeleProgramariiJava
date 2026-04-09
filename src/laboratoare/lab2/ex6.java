package laboratoare.lab2;

import java.util.Scanner;

public class ex6 {

    static class Node {
        String nume;
        String telefon;
        Node next;

        Node(String nume, String telefon) {
            this.nume = nume;
            this.telefon = telefon;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("  %-20s | Telefon: %s", nume, telefon);
        }
    }

    static class ListaConsumatori {
        private Node head;

        public void adauga(String nume, String telefon) {
            Node nou = new Node(nume, telefon);

            if (head == null) {
                head = nou;
            } else {
                Node curent = head;

                while (curent.next != null) {
                    curent = curent.next;
                }
                curent.next = nou;
            }
        }

        public boolean sterge(String nume) {
            if (head == null) {
                return false;
            }

            if (head.nume.equalsIgnoreCase(nume)) {
                head = head.next;
                return true;
            }

            Node curent = head;

            while (curent.next != null) {

                if (curent.next.nume.equalsIgnoreCase(nume)) {
                    curent.next = curent.next.next;
                    return true;
                }
                curent = curent.next;
            }

            return false;
        }

        public void afiseaza() {

            if (head == null) {
                System.out.println("Lista este goală.");
                return;
            }

            System.out.println("\n" + "=".repeat(50));
            System.out.println("       LISTA CONSUMATORI");
            System.out.println("=".repeat(50));

            Node curent = head;
            int contor = 1;

            while (curent != null) {
                System.out.printf("%2d. %s%n", contor++, curent);
                curent = curent.next;
            }

            System.out.println("=".repeat(50));
        }
    }

    static void main(String[] args) {
        ListaConsumatori lista = new ListaConsumatori();

        lista.adauga("Ion Popescu", "0721234567");
        lista.adauga("Maria Ionescu", "0732345678");
        lista.adauga("Andrei Rusu", "0743456789");
        lista.adauga("Elena Munteanu", "0754567890");
        lista.adauga("Vlad Constantin", "0765678901");

        System.out.println("Lista inițială:");
        lista.afiseaza();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduceți numele consumatorului de șters: ");
        String numeDeSters = sc.nextLine();

        if (lista.sterge(numeDeSters)) {
            System.out.println("\nConsumator \"" + numeDeSters + "\" a fost șters cu succes.");
        } else {
            System.out.println("\nConsumator \"" + numeDeSters + "\" nu a fost găsit în listă.");
        }

        System.out.println("\nLista după ștergere:");
        lista.afiseaza();

        sc.close();
    }
}
