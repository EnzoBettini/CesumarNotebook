package Metodos.Circulo;

public class Circulo {
    double raio;

    Circulo (double raio) {
        this.raio = raio;
    }

    double calcularArea(){
        return Math.PI * Math.pow(this.raio, 2);
    }

    double calcularCircunferencia(){
        return Math.PI * 2 *  this.raio;
    }
}
