package ListaExercicios;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite qualquer inteiro");
        int num = sc.nextInt();

        System.out.printf("\nSeu numero e %d -- antecessor: %d -- sucessor: %d", num, num-1, num+1);
    }
}
