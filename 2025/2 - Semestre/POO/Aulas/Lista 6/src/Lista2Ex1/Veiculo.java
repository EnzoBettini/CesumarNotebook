package Lista2Ex1;

public abstract class Veiculo {
    private String modelo;
    private double valorDiaria;

    public Veiculo(String modelo, double valorDiaria) {
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    // Método abstrato — não tem corpo e deve ser implementado pelas subclasses
    public abstract double calcularSeguro();
}

