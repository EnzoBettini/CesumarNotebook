package domain;

public class Produto {
    private String codigo;
    private String nome;
    private double precoFinal;
    private int quantidadeEstoque;
    private String fornecedor;
    private boolean disponivel;

    public Produto() {
    }

    public Produto(String codigo, String nome, double precoFinal, int quantidadeEstoque, String fornecedor, boolean disponivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoFinal = precoFinal;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedor = fornecedor;
        this.disponivel = disponivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", precoFinal=" + precoFinal +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", fornecedor='" + fornecedor + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
