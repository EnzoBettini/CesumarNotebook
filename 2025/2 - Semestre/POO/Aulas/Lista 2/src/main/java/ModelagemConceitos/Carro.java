package ModelagemConceitos;

public class Carro {
    String nome;
    int portas;
    int capacidade;
    int velocidade_max;
    double consumo;

    Carro (String nome, int portas, int capacidade, int velocidade_max, double consumo) {
        this.nome = nome;
        this.portas = portas;
        this.capacidade = capacidade;
        this.velocidade_max = velocidade_max;
        this.consumo = consumo;
    }

    double getConsumo() {
        return 0;
    }
    void fecharVidro() {}
    void liberar7lugares() {}
    void limitarVelocidade() {}
    void consumoViagem() {}
}
