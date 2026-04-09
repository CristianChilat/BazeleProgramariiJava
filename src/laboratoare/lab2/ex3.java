package laboratoare.lab2;

import java.util.*;

public class ex3 {

    static class Node {
        String nume;
        int an;
        String grupa;
        double notaMedie;
        Node next;

        Node(String nume, int an, String grupa, double notaMedie) {
            this.nume = nume;
            this.an = an;
            this.grupa = grupa;
            this.notaMedie = notaMedie;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("  %-20s | An: %d | Nota medie: %.2f", nume, an, notaMedie);
        }
    }

    static class ListaStudenti {
        private Node head;
        private int size;

        public void adauga(String nume, int an, String grupa, double notaMedie) {
            Node nou = new Node(nume, an, grupa, notaMedie);

            if (head == null) {
                head = nou;
            } else {
                Node curent = head;
                while (curent.next != null) {
                    curent = curent.next;
                }
                curent.next = nou;
            }
            size++;
        }

        public void afiseazaPeGroupe() {

            if (head == null) {
                System.out.println("Lista este goală.");
                return;
            }

            Set<String> grupe = new TreeSet<>();
            Node curent = head;

            while (curent != null) {
                grupe.add(curent.grupa);
                curent = curent.next;
            }

            System.out.println("=".repeat(55));
            System.out.println("       LISTA STUDENȚILOR PE GRUPE");
            System.out.println("=".repeat(55));

            for (String grupa : grupe) {
                System.out.println("\n  Grupa: " + grupa);
                System.out.println("  " + "-".repeat(50));

                curent = head;
                int contor = 0;

                while (curent != null) {

                    if (curent.grupa.equals(grupa)) {
                        System.out.println(curent);
                        contor++;
                    }
                    curent = curent.next;
                }

                System.out.printf("  Total studenti in grupa %s: %d%n", grupa, contor);
            }

            System.out.println("\n" + "=".repeat(55));
            System.out.println("  Total studenti in lista: " + size);
            System.out.println("=".repeat(55));
        }

        public void afiseazaToate() {
            System.out.println("\n── Lista completă ──────────────────────────────────────");
            Node curent = head;
            int i = 1;

            while (curent != null) {
                System.out.printf("  %2d. %-20s | An: %d | Grupa: %-6s | Nota: %.2f%n",
                        i++, curent.nume, curent.an, curent.grupa, curent.notaMedie);
                curent = curent.next;
            }
            System.out.println("────────────────────────────────────────────────────────");
        }
    }

    static void main(String[] args) {

        ListaStudenti lista = new ListaStudenti();

        lista.adauga("Ion Popescu",      1, "CS-101", 8.75);
        lista.adauga("Maria Ionescu",    2, "CS-201", 9.20);
        lista.adauga("Andrei Rusu",      1, "CS-102", 7.50);
        lista.adauga("Elena Munteanu",   3, "CS-301", 9.80);
        lista.adauga("Vlad Constantin",  2, "CS-201", 8.10);
        lista.adauga("Ana Ciobanu",      1, "CS-101", 9.00);
        lista.adauga("Mihai Popa",       3, "CS-301", 7.90);
        lista.adauga("Cristina Dima",    2, "CS-202", 8.45);
        lista.adauga("Alexandru Stoica", 1, "CS-102", 6.80);
        lista.adauga("Raluca Moraru",    3, "CS-302", 9.10);
        lista.adauga("Daniel Luca",      2, "CS-202", 7.30);
        lista.adauga("Ioana Neagu",      1, "CS-101", 8.60);

        lista.afiseazaToate();

        lista.afiseazaPeGroupe();
    }
}