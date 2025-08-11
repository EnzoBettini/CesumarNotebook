package ListaExercicios;

public class Exercicio21 {
    public static void main(String[] args) {
        int counter = 0;

        for(int i = 1; i <= 100; i++){
            counter += i;
        }
        System.out.printf("Numero de 1 a 100 somados: %d\n", counter);
    }
}
