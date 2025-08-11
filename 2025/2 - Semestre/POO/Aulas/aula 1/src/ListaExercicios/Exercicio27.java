package ListaExercicios;

import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int contador = 0;

        String frase;
        System.out.println("Digite uma frase:");
        frase = entrada.nextLine();

        for(int i = 0; i < frase.length(); i++) {
            Character c = frase.charAt(i);
            if ("aeiouAEIOU".indexOf(c) != -1){
                contador++;
            }
        }

        System.out.printf("Numero de vogais na sua palavras: %d",  contador);
    }
}
