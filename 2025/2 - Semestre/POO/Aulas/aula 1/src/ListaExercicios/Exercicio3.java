package ListaExercicios;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o 1 numero");
        int num1 = sc.nextInt();
        System.out.println("Digite o 2 numero");
        int num2 = sc.nextInt();

        System.out.printf("\nA soma dos numeros e: %d", (num1 + num2));
    }
}
