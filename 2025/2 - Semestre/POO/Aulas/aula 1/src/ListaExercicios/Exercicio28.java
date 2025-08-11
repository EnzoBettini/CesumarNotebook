package ListaExercicios;

import java.util.Scanner;

public class Exercicio28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senha;

        System.out.println("Senha: ");
        senha = sc.nextLine();

        if (senha.length() >= 8){
            System.out.println("Senha com tamanho bom");
        } else {
            System.out.println("Senha com menos de 8 caracteres");
        }
    }
}
