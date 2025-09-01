package Computadores;

public class MemoriaRAM {
    private int capacidadeGB;
    private String tipo;

    public MemoriaRAM(int capacidadeGB, String tipo) {
        this.capacidadeGB = capacidadeGB;
        this.tipo = tipo;
    }

    public int getCapacidadeGB() {
        return capacidadeGB;
    }

    public String getTipo() {
        return tipo;
    }
}
