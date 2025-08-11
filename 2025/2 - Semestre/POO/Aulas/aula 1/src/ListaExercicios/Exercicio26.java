package ListaExercicios;

import java.util.Scanner;

public class Exercicio26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um nome:");
        String nome = sc.nextLine();
        System.out.println(new StringBuilder(nome).reverse());
        System.out.println(nome);
    }
}
