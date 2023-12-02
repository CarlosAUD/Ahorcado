import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        List<String> banc = new ArrayList<>();
        Scanner letra = new Scanner(System.in);
        banc.add("computadora");
        banc.add("caballo");
        banc.add("computadora");
        banc.add("gato");
        int a = (int) ((Math.random() * 4) + 1);
        int error = 0, nume;
        boolean confi = false;
        String letras;
        String palabra = banc.get(a);
        String copia = palabra;
        StringBuilder copiaModificada = new StringBuilder();
        for (int i = 0; i < copia.length(); i++) {
            copiaModificada.append('*');
        }
        copia = copiaModificada.toString();
        while (error != 6 && !confi) {
            System.out.println("----EL AHORCADO----");
            System.out.print("Escribe una letra: ");
            letras = letra.nextLine();
            int p = palabra.indexOf(letras);
            if (p != -1) {
                while (p != -1) {
                    copia = copia.substring(0, p) + letras + copia.substring(p + 1);
                    p = palabra.indexOf(letras, p + 1);
                }
                System.out.println("Errores: " + error);
                if (copia.equals(palabra)) {
                    System.out.println("¡Ganaste!");
                    confi = true;
                }
            } else {
                System.out.println("Fallaste.");
                error += 1;
                mostrarAhorcado(error);
                System.out.println("Errores: " + error);
            }
            System.out.println(copia);

        }
    }
    
    private static void mostrarAhorcado(int errores) {
        switch (errores) {
            case 1:
                System.out.println("  O  ");
                break;
            case 2:
                System.out.println("  O  ");
                System.out.println(" /   ");
                break;
            case 3:
                System.out.println("  O  ");
                System.out.println(" /|  ");
                break;
            case 4:
                System.out.println("  O  ");
                System.out.println(" /|\\");
                break;
            case 5:
                System.out.println("  O  ");
                System.out.println(" /|\\");
                System.out.println(" |   ");
                break;
            case 6:
                System.out.println("  O  ");
                System.out.println(" /|\\");
                System.out.println(" | | ");
                System.out.println("Perdiste");
                break;
        }
    }
}
