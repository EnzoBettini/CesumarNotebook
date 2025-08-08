package ListaExercicios;

import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero");
        int num = sc.nextInt();
        System.out.println("Digite um numero");
        int num2 = sc.nextInt();

        if (num < num2){
            System.out.printf("\n num 2 = %d e o maior",  num2);
        } else if (num > num2){
            System.out.printf("\n num 1 = %d e o maior",  num);
        } else {
            System.out.println("OS NUMEROS SAO IGUAIS");
        }
    }
}
