package Sistema_de_vendas;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void exibirDetalhes() {
        System.out.println("Pedido do Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        System.out.println("Produtos:");
        double total = 0;
        for (Produto p : produtos) {
            System.out.println("- " + p.getNome() + " - R$ " + p.getPreco());
            total += p.getPreco();
        }
        System.out.println("Total: R$ " + total);
    }
}
