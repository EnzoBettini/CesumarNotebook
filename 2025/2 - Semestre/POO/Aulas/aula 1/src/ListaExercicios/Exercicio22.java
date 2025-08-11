package ListaExercicios;

public class Exercicio22 {
    public static void main(String[] args) {
        int counter = 0;

        for(int i = 1; i <= 100; i++){
            if (i % 2 == 0) {
                counter += i;
            }
        }
        System.out.printf("Numero de 1 a 100 pares somados: %d\n", counter);
    }
}
