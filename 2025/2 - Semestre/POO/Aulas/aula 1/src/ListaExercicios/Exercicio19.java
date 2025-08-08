package ListaExercicios;

import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int suma = 0;
        int numero;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite um numero: ");
            numero = in.nextInt();
            suma += numero;
        }

        System.out.printf("A media total e %f",(float) (suma / 5));
    }
}
