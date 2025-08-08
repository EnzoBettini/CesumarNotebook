package ListaExercicios;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite um numero");
        int num = entrada.nextInt();

        if (num % 2 == 0) {
            System.out.println("O NUMERO E PAR");
        } else {
            System.out.println("O NUMERO E IMPAR");
        }
    }
}
