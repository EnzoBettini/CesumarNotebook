package ListaExercicios;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite qualquer inteiro");
        int num = sc.nextInt();

        System.out.printf("dobro: %d\n", num*2);
        System.out.printf("triplo: %d\n", num*3);
        double num2 = Math.pow(num, 2);
        System.out.printf("elevado a 2: %.0f\n", num2);
    }
}
