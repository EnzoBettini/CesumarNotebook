package Lista2Ex1;

public class Carro extends Veiculo {

    public Carro(String modelo, double valorDiaria) {
        super(modelo, valorDiaria);
    }

    @Override
    public double calcularSeguro() {
        // Exemplo simples: 10% do valor da diária
        return getValorDiaria() * 0.10;
    }
}

