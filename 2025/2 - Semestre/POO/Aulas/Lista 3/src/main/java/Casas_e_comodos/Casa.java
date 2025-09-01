package Casas_e_comodos;
import java.util.List;

public class Casa {
    private String endereco;
    private List<Comodo> comodos;

    public Casa(String endereco, List<Comodo> comodos) {
        this.endereco = endereco;
        this.comodos = comodos;
    }

    public void exibirDetalhes() {
        System.out.println("Casa localizada em: " + endereco);
        System.out.println("Cômodos:");
        for (Comodo c : comodos) {
            System.out.println("- " + c.getNome());
        }
    }
}