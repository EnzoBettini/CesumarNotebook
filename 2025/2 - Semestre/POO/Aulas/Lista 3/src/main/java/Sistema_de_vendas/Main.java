package Sistema_de_vendas;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Pereira", "123.456.789-00");

        Produto p1 = new Produto("Notebook", 3500.00);
        Produto p2 = new Produto("Mouse", 150.00);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(p1);
        pedido.adicionarProduto(p2);

        pedido.exibirDetalhes();
    }
}
