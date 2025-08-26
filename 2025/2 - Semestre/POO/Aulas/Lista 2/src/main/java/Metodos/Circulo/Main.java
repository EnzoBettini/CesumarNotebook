package Metodos.Circulo;

public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(10);

        double areaCirculo = circulo.calcularArea();
        System.out.printf("Area circulo: %.2f\n", areaCirculo);

        double circunferencia =  circulo.calcularCircunferencia();
        System.out.printf("Circunferencia: %.2f\n", circunferencia);
    }
}
