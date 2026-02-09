package Lista2Ex1;

public class Moto extends Veiculo {

    public Moto(String modelo, double valorDiaria) {
        super(modelo, valorDiaria);
    }

    @Override
    public double calcularSeguro() {
        // Exemplo simples: 5% do valor da diária
        return getValorDiaria() * 0.05;
    }
}

