import java.util.Scanner;

public class Exercicio_1 {

    public static void main(String[] args) {

//        System.out.println("Digite um numero: ");
//        System.out.printf("Olá %d, isso é um numero", 10);

        Scanner sc = new Scanner(System.in);
        boolean verificador = true;

        double nota_1 = 0;
        while (verificador) {
            System.out.println("Digite a nota 1");
            nota_1 = sc.nextDouble();
            if (nota_1 >= 0 && nota_1 <=10){
                verificador = false;
            }
        }

        verificador = true;

        double nota_2 = 0;
        while (verificador) {
            System.out.println("Digite a nota 2");
            nota_2 = sc.nextDouble();
            if (nota_2 >= 0 && nota_2 <=10){
                verificador = false;
            }
        }

        System.out.printf("Sua Média é: %.2f", CalcMedia(nota_1, nota_2));
    }
    public static double CalcMedia(double n1, double n2){
        return (n1 + n2) / 2;
    }
}
