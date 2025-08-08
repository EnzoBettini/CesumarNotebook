package ListaExercicios;

import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero");
        int num = sc.nextInt();

        if (num < 18){
            System.out.printf("\nMenor de idade - %d",  num);
        } else {
            System.out.printf("\nMaior de idade - %d\"",  num);
        }
    }

}
