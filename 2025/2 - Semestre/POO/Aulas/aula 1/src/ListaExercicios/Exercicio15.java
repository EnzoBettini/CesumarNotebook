package ListaExercicios;

import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = in.nextInt();

        if (num == 1234){
            System.out.println("Acesso liberado");
        } else {
            System.out.println("Acesso negado");
        }
    }
}
