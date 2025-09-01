package Computadores;
import java.util.ArrayList;
import java.util.List;

public class Computador {
    private Processador processador;
    private MemoriaRAM memoriaRAM;
    private List<Periferico> perifericos;

    public Computador(Processador processador, MemoriaRAM memoriaRAM) {
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.perifericos = new ArrayList<>();
    }

    public void adicionarPeriferico(Periferico periferico) {
        perifericos.add(periferico);
    }

    public void exibirDetalhes() {
        System.out.println("Computador:");
        System.out.println("Processador: " + processador.getModelo() + " - " + processador.getVelocidadeGHz() + "GHz");
        System.out.println("Memória RAM: " + memoriaRAM.getCapacidadeGB() + "GB " + memoriaRAM.getTipo());

        if (perifericos.isEmpty()) {
            System.out.println("Sem periféricos conectados.");
        } else {
            System.out.println("Periféricos:");
            for (Periferico p : perifericos) {
                System.out.println("- " + p.getNome());
            }
        }
    }
}

