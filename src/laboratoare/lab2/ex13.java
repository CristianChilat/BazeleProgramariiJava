package laboratoare.lab2;

public class ex13 {

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
            return String.format("%-20s | An: %d | Grupa: %-6s | Nota: %.2f",
                nume, an, grupa, notaMedie);
        }
    }

    static class ListaStudenti {
        private Node head;

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
        }

        public void sorteazaAlfabetic() {

            if (head == null || head.next == null) {
                return;
            }

            boolean schimbat;
            do {
                schimbat = false;
                Node curent = head;

                while (curent.next != null) {

                    if (curent.nume.compareToIgnoreCase(curent.next.nume) > 0) {
                        String tempNume = curent.nume;
                        int tempAn = curent.an;
                        String tempGrupa = curent.grupa;
                        double tempNota = curent.notaMedie;

                        curent.nume = curent.next.nume;
                        curent.an = curent.next.an;
                        curent.grupa = curent.next.grupa;
                        curent.notaMedie = curent.next.notaMedie;

                        curent.next.nume = tempNume;
                        curent.next.an = tempAn;
                        curent.next.grupa = tempGrupa;
                        curent.next.notaMedie = tempNota;

                        schimbat = true;
                    }
                    curent = curent.next;
                }
            } while (schimbat);
        }

        public void afiseazaCuNotaPeste8() {

            if (head == null) {
                System.out.println("Lista este goală.");
                return;
            }

            System.out.println("\nStudenți cu nota medie > 8 (ordine alfabetică):");
            System.out.println("=".repeat(65));

            Node curent = head;
            int contor = 0;

            while (curent != null) {

                if (curent.notaMedie > 8.0) {
                    System.out.printf("%2d. %s%n", ++contor, curent);
                }
                curent = curent.next;
            }

            if (contor == 0) {
                System.out.println("Nu există studenți cu nota medie > 8.");
            }

            System.out.println("=".repeat(65));
        }
    }

    static void main(String[] args) {
        ListaStudenti lista = new ListaStudenti();

        lista.adauga("Ion Popescu", 1, "CS-101", 8.75);
        lista.adauga("Maria Ionescu", 2, "CS-201", 9.20);
        lista.adauga("Andrei Rusu", 1, "CS-102", 7.50);
        lista.adauga("Elena Munteanu", 3, "CS-301", 9.80);
        lista.adauga("Vlad Constantin", 2, "CS-201", 8.10);
        lista.adauga("Ana Ciobanu", 1, "CS-101", 9.00);
        lista.adauga("Mihai Popa", 3, "CS-301", 7.90);
        lista.adauga("Cristina Dima", 2, "CS-202", 8.45);
        lista.adauga("Alexandru Stoica", 1, "CS-102", 6.80);
        lista.adauga("Raluca Moraru", 3, "CS-302", 9.10);

        lista.sorteazaAlfabetic();
        lista.afiseazaCuNotaPeste8();
    }
}