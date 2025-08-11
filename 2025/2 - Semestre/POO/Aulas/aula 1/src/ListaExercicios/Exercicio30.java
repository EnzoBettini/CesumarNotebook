package ListaExercicios;

import java.util.Scanner;

public class Exercicio30 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        StringBuilder palavra = new StringBuilder();

        System.out.println("Digite uma palavra: ");
        palavra.append(entrada.nextLine());

        if (palavra.toString().contentEquals(palavra.reverse())) {
            System.out.println("Palavra e um palindromo");
        } else {
            System.out.println("Palavra nao e um palindromo");
        }
    }
}
