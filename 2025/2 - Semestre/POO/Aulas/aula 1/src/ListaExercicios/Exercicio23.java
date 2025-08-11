package ListaExercicios;

import java.util.Scanner;

public class Exercicio23 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double soma = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um numero: ");
            soma += entrada.nextDouble();
        }
        System.out.printf("Soma dos seus numeros: %f\n", soma);
    }
}