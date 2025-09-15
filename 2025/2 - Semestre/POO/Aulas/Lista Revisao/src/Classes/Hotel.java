package Classes;

import java.util.List;
import java.util.ArrayList;

public class Hotel {
    private String nome;
    private String endereco;
    private List<Quarto> quartos;

    public Hotel (String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.quartos = new ArrayList<>();
    }

    public void adicionarQuarto(int numero, String tipo, double precoPorNoite) {
        Quarto quartoAdd = new Quarto(numero, tipo, precoPorNoite);
        this.quartos.add(quartoAdd);
        System.out.println("Quarto adicionado com sucesso!");
    }

    public void hospedar(Hospede hospede, int numeroQuarto) {
        for (Quarto quarto : this.quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                quarto.ocupar(hospede);
                System.out.println("Hospede adicionado com sucesso!");
                return;
            }
        }
        System.out.println("Quarto não encontrado!");
    }

    public void realizarCheckout(int numeroQuarto) {
        for (Quarto quarto : this.quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                quarto.liberar();
                return;
            }
        }
        System.out.println("Quarto não encontrado!");
    }

    public void exibirRelatório() {
        for (Quarto quarto: this.quartos) {
            System.out.printf("Número quarto: %s\n", quarto.getNumero());
            System.out.printf("Ocupado?: %s\n", quarto.isOcupado() ? "Sim" : "Não");
            System.out.println();
        }
    }
}
