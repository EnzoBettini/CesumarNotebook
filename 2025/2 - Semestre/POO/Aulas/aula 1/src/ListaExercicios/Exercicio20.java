package ListaExercicios;

import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = in.nextInt();

        for(;num >= 0; num--){
            System.out.printf("%d ", num);
        }
    }
}
