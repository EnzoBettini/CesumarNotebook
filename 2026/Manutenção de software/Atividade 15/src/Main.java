import adapter.AtacadoBrasilAdapter;
import adapter.GlobalMarketAdapter;
import domain.Produto;
import externo.AtacadoBrasilApi;
import externo.GlobalMarketApi;
import repository.CatalogoProdutos;

public class Main {
    public static void main(String[] args) {
        CatalogoProdutos catalogoAtacadoBrasil =
                new AtacadoBrasilAdapter(new AtacadoBrasilApi());

        CatalogoProdutos catalogoGlobalMarket =
                new GlobalMarketAdapter(new GlobalMarketApi());

        System.out.println("Produtos do Atacado Brasil:");
        for (Produto produto : catalogoAtacadoBrasil.listarProdutos()) {
            System.out.println(produto);
        }

        System.out.println();

        System.out.println("Produtos do Global Market:");
        for (Produto produto : catalogoGlobalMarket.listarProdutos()) {
            System.out.println(produto);
        }
    }
}
