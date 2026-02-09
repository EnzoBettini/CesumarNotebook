package Lista1Ex7;

public class Produto implements ExportavelCSV {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toCSV() {
        return nome + ";" + preco;
    }
}
