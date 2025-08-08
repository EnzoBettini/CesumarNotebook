package ListaExercicios;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double tx_convrsao = 5.5;

        System.out.println("Digite o valor em reais");
        double input = sc.nextDouble();

        System.out.printf("O valor R$%.2f = U$%.2f", input, (tx_convrsao/input)*100);
    }
}
