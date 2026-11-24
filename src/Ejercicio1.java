import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner ruben = new Scanner(System.in);
        ArrayList<Float> notesAlumnes = new ArrayList<>();
        ArrayList<String> nomsAlumnes = new ArrayList<>();

        int opcio;
        do {
            mostrarMenu();
            opcio = llegirEnter(ruben);

            switch (opcio) {
                case 1:
                    afegirNota(ruben, notesAlumnes, nomsAlumnes);
                    break;
                case 2:
                    consultarNota(ruben, notesAlumnes, nomsAlumnes);
                    break;
                case 3:
                    eliminarNota(ruben, notesAlumnes, nomsAlumnes);
                    break;
                case 4:
                    modificarNota(ruben, notesAlumnes, nomsAlumnes);
                    break;
                case 5:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció incorrecta.");
            }
        } while (opcio != 5);

        ruben.close();
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("Notes de M04-UF1");
        System.out.println("1. Introduir nota");
        System.out.println("2. Consultar nota");
        System.out.println("3. Eliminar nota");
        System.out.println("4. Modificar nota");
        System.out.println("5. Sortir");
        System.out.print("Tria una opció: ");
    }

    public static int llegirEnter(Scanner ruben) {
        if (ruben.hasNextInt()) {
            int numero = ruben.nextInt();
            ruben.nextLine();
            return numero;
        }

        ruben.nextLine();
        return -1;
    }

    public static float llegirNota(Scanner ruben) {
        System.out.print("Introdueix la nota (0-10): ");

        if (ruben.hasNextFloat()) {
            float nota = ruben.nextFloat();
            ruben.nextLine();

            if (nota >= 0 && nota <= 10) {
                return nota;
            }
        } else {
            ruben.nextLine();
        }

        System.out.println("Nota incorrecta.");
        return -1;
    }

    public static int llegirIndex(Scanner ruben, ArrayList<Float> notesAlumnes) {
        if (notesAlumnes.size() == 0) {
            System.out.println("Encara no hi ha notes.");
            return -1;
        }

        System.out.print("Introdueix l'índex (0-" + (notesAlumnes.size() - 1) + "): ");
        int index = llegirEnter(ruben);

        if (index < 0 || index >= notesAlumnes.size()) {
            System.out.println("Índex incorrecte.");
            return -1;
        }

        return index;
    }

    public static void afegirNota(Scanner ruben, ArrayList<Float> notesAlumnes, ArrayList<String> nomsAlumnes) {
        System.out.print("Nom de l'alumne: ");
        String nom = ruben.nextLine();
        float nota = llegirNota(ruben);

        if (nota != -1) {
            notesAlumnes.add(nota);
            nomsAlumnes.add(nom);
            System.out.println("Nota afegida.");
        }
    }

    public static void consultarNota(Scanner ruben, ArrayList<Float> notesAlumnes, ArrayList<String> nomsAlumnes) {
        int index = llegirIndex(ruben, notesAlumnes);

        if (index != -1) {
            System.out.println(nomsAlumnes.get(index) + ": " + notesAlumnes.get(index));
        }
    }

    public static void eliminarNota(Scanner ruben, ArrayList<Float> notesAlumnes, ArrayList<String> nomsAlumnes) {
        int index = llegirIndex(ruben, notesAlumnes);

        if (index != -1) {
            notesAlumnes.remove(index);
            nomsAlumnes.remove(index);
            System.out.println("Nota eliminada.");
        }
    }

    public static void modificarNota(Scanner ruben, ArrayList<Float> notesAlumnes, ArrayList<String> nomsAlumnes) {
        int index = llegirIndex(ruben, notesAlumnes);

        if (index != -1) {
            float nota = llegirNota(ruben);

            if (nota != -1) {
                notesAlumnes.set(index, nota);
                System.out.println("Nota modificada de " + nomsAlumnes.get(index) + ".");
            }
        }
    }
}
