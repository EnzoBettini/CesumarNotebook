package ListaExercicios;

public class Exercicio17 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i=0; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.printf("soma: %d", sum);
    }
}
