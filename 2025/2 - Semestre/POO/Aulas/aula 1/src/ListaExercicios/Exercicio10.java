package ListaExercicios;

import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero");
        int num = sc.nextInt();

        if (num > 0){
            System.out.printf("\n%d e maior que zero",  num);
        } else if (num < 0){
            System.out.printf("\n%d e menor que zero",  num);
        } else {
            System.out.println("OS NUMEROS SAO IGUAIS");
        }
    }
}
