package br.edu.unicesumar.ex5;

public class VeiculoService {

    private final VeiculoBanco storage = new VeiculoBanco();

    public void adicionarVeiculo(String placa, String marca, String modelo, int ano) {
        var vehicle = new Veiculo(placa, marca, modelo, ano);
        storage.inserirVeiculo(vehicle);
    }

    public void mostrarPatio() {
        storage.listarPatio();
    }

    public void mostrarPorPlaca(String placa) {
        storage.buscarPorPlaca(placa);
    }

    public void atualizarAno(String placa, int ano) {
        storage.atualizarAno(placa, ano);
    }

    public void venderVeiculo(String placa) {
        storage.venderVeiculo(placa);
    }
}
