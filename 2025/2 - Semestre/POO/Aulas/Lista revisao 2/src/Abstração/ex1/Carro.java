package Abstração.ex1;

public class Carro extends Veiculo {
    public Integer aroRoda;

    public Carro(Integer modelo, String marca, Integer aroRoda) {
        super(modelo, marca);
        this.aroRoda = aroRoda;
    }

    @Override
    public void CalcularSeguro() {
        System.out.println("Seguro para carro calculado: 15");
    }

    @Override
    public void CalcularPedagio() {
        System.out.println("Pedagio para carro calculado: 15");
    }
}
