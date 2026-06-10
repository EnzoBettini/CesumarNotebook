package adapter;

import domain.Produto;
import externo.AtacadoBrasilApi;
import repository.CatalogoProdutos;

import java.util.ArrayList;
import java.util.List;

public class AtacadoBrasilAdapter implements CatalogoProdutos {

    private final AtacadoBrasilApi api;

    public AtacadoBrasilAdapter(AtacadoBrasilApi api) {
        this.api = api;
    }

    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        for (String[] dados : api.buscarProdutosAtacado()) {
            String codigo = dados[0];
            String nome = dados[1];
            double precoFinal = Double.parseDouble(dados[2]);
            int quantidadeEstoque = Integer.parseInt(dados[3]);
            boolean disponivel = quantidadeEstoque > 0;

            produtos.add(new Produto(
                    codigo,
                    nome,
                    precoFinal,
                    quantidadeEstoque,
                    "Atacado Brasil",
                    disponivel
            ));
        }

        return produtos;
    }
}
