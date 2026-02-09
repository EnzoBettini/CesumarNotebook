package br.edu.unicesumar.ex1;

public class ProdutoService {
    private final ProdutoBanco dao = new ProdutoBanco();

    public void adicionarProduto(String nome, double preco, int quantidade) {
        var product = new Produto(nome, preco, quantidade);
        dao.inserirProduto(product);
    }

    public void mostrarProdutos() {
        dao.listarProdutos();
    }

    public void alterarPrecoProduto(int id, double novoPreco) {
        dao.updateProduto(id, novoPreco);
    }

    public void excluirProduto(int id) {
        dao.deletarProduto(id);
    }
}
