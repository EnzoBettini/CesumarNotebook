package Casas_e_comodos;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Comodo> comodos = new ArrayList<>();
        comodos.add(new Comodo("Sala"));
        comodos.add(new Comodo("Cozinha"));
        comodos.add(new Comodo("Quarto"));
        comodos.add(new Comodo("Banheiro"));

        Casa casa = new Casa("Av. Brasil, 123", comodos);
        casa.exibirDetalhes();
    }
}