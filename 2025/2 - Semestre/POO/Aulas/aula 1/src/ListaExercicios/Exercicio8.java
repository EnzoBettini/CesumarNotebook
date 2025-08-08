package ListaExercicios;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero");
        int num = sc.nextInt();

        System.out.printf(" \nquadrado: %.2f", Math.pow(num,2));
        System.out.printf(" \ncubo: %.2f", Math.pow(num,3));
    }
}
