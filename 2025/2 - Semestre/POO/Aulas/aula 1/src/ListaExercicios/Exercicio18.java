package ListaExercicios;

import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int suma = 0;
        int numero = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um numero: ");
            numero = in.nextInt();
            suma += numero;
        }

        System.out.printf("Soma total %d", suma);
    }
}
