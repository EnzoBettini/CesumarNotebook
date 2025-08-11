package ListaExercicios;

import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome;

        System.out.println("Digite seu nome: ");
        nome = leitor.nextLine();

        char firstLetter = nome.charAt(0);

        if ("A".indexOf(firstLetter) != -1){
            System.out.println("Seu nome comeca com A");
        } else {
            System.out.println("Seu nome nao pussui A no primeiro caractere");
        }


    }
}
