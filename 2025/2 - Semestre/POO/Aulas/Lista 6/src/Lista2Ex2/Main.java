package Lista2Ex2;

public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(5.0);
        Quadrado q = new Quadrado(4.0);

        System.out.println("Círculo - Área: " + c.calcularArea() + ", Perímetro: " + c.calcularPerimetro());
        System.out.println("Quadrado - Área: " + q.calcularArea() + ", Perímetro: " + q.calcularPerimetro());
    }
}

