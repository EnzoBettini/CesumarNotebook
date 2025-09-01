package Carros_e_motores;

public class Carro {
    private String marca;
    private String modelo;
    private Motor motor;

    public Carro(String marca, String modelo, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }

    public void exibirDetalhes() {
        System.out.println("Carro: " + marca + " " + modelo);
        System.out.println("Motor: " + motor.getPotencia() + "cv - " + motor.getTipoCombustivel());
    }

    public static void main(String[] args) {
        Motor motor = new Motor(150, "Gasolina");
        Carro carro = new Carro("Toyota", "Corolla", motor);
        carro.exibirDetalhes();
    }
}

