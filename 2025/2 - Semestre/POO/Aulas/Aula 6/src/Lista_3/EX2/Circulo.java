package Lista_3.EX2;

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void calcularArea(){
        double area = Math.PI * Math.pow(raio, 2);

        System.out.printf("Area: %.2f\n", area);
    }

    public void calcularPerimetro(){
        double perimetro = 2 * Math.PI * raio;
        System.out.printf("Perimetro: %.2f\n", perimetro);
    }
}
