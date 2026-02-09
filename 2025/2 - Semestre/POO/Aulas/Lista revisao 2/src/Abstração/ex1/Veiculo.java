package Abstração.ex1;

public abstract class Veiculo {
    public Integer modelo;
    public String marca;

    Veiculo(Integer modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public abstract void CalcularSeguro();

    public abstract void CalcularPedagio();

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
