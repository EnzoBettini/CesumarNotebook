package Abstração.ex1;

public class Moto extends Veiculo {
    public Moto(Integer modelo, String marca) {
        super(modelo, marca);
    }

    @Override
    public void CalcularSeguro() {
        System.out.println("Seguro para moto calculado: 10");
    }
    @Override
    public void CalcularPedagio() {
        System.out.println("Pedagio para moto calculado: 9");
    }
}
