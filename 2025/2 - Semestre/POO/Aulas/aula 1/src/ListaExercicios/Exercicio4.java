package ListaExercicios;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o 1 numero");
        float num1 = sc.nextFloat();
        System.out.println("Digite o 2 numero");
        float num2 = sc.nextFloat();
        System.out.println("Digite o 2 numero");
        float num3 = sc.nextFloat();

        System.out.printf("A media dos numeros e %f", (num1 + num2 + num3)/3);
    }
}
