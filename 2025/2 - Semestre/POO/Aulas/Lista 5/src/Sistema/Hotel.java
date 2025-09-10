package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private String endereco;
    private List<Quarto> quartos;

    Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.quartos = new ArrayList<Quarto>();
    }

    void adicionarQuarto(String tipo, int numero, Double preco){
        Quarto quarto = new Quarto(numero, tipo, preco);
        this.quartos.add(quarto);
    }

        void hospedar(Hospede hospede, int numero){
            for(Quarto quarto : this.quartos){
                if(quarto.getNumero() == numero){
                    quarto.ocupar(hospede);
                    System.out.println("Hospede adicionado com sucesso");
                    return;
                }
            }
            System.out.println("Quarto inexistente");
            System.out.println();
        }

    void realizarCheckout(int quartoNum){
        for (Quarto quarto1 : this.quartos){
            if(quarto1.getNumero() == quartoNum){
                if(quarto1.isOcupado() == true){
                    quarto1.liberar();
                    System.out.println("Quarto liberado com sucesso!");
                } else {
                    System.out.println("Quarto sem hospede cadastrado!");
                }
            }
        }
    }

    void checarHospedes() {
        System.out.println("=== Lista de Quartos ===\n");

        for (Quarto quarto : this.quartos) {
            System.out.printf("Quarto Nº: %d\n", quarto.getNumero());
            System.out.printf("Tipo: %s\n", quarto.getTipo());
            System.out.printf("Ocupado: %s\n", quarto.isOcupado() ? "Sim" : "Não");

            if (quarto.isOcupado()) {
                System.out.printf("Hóspede: %s\n", quarto.getHospede().getNome());
            }

            System.out.println("---------------------------");
        }
    }

}
