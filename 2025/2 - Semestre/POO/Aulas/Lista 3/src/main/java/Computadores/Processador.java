package Computadores;


public class Processador {
    private String modelo;
    private double velocidadeGHz;

    public Processador(String modelo, double velocidadeGHz) {
        this.modelo = modelo;
        this.velocidadeGHz = velocidadeGHz;
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidadeGHz() {
        return velocidadeGHz;
    }
}
