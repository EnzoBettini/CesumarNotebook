package ListaExercicios;

import java.util.Scanner;

public class Exercicio25 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        double number = 0;

        while (continuar) {
            System.out.println("Digite um numero:");
            number = entrada.nextDouble();
            if (number == 0) {
                continuar = false;
            }
        }
    }
}
