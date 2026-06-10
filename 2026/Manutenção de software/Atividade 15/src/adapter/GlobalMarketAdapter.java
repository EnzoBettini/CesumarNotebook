package adapter;

import domain.ItemGlobal;
import domain.Produto;
import externo.GlobalMarketApi;
import repository.CatalogoProdutos;

import java.util.ArrayList;
import java.util.List;

public class GlobalMarketAdapter implements CatalogoProdutos {

    private static final double COTACAO_DOLAR = 5.0;

    private final GlobalMarketApi api;

    public GlobalMarketAdapter(GlobalMarketApi api) {
        this.api = api;
    }

    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        for (ItemGlobal item : api.fetchAvailableItems()) {
            String codigo = item.getSku();
            String nome = item.getDescription();
            double precoFinal = item.getPriceInDollars() * COTACAO_DOLAR;
            int quantidadeEstoque = item.getAvailableUnits();
            boolean disponivel = quantidadeEstoque > 0;

            produtos.add(new Produto(
                    codigo,
                    nome,
                    precoFinal,
                    quantidadeEstoque,
                    "Global Market",
                    disponivel
            ));
        }

        return produtos;
    }
}
