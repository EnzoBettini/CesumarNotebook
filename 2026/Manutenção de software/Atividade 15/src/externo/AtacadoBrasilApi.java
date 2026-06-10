package externo;

import java.util.ArrayList;
import java.util.List;

public class AtacadoBrasilApi {

    public List<String[]> buscarProdutosAtacado() {
        List<String[]> produtos = new ArrayList<>();

        produtos.add(new String[]{"A100", "Teclado Mecânico", "250.00", "12"});
        produtos.add(new String[]{"A200", "Monitor 24 Polegadas", "899.90", "4"});
        produtos.add(new String[]{"A300", "Cadeira Gamer", "1200.00", "0"});

        return produtos;
    }
}
