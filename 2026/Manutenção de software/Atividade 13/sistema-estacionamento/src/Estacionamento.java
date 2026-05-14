package br.edu.refactoring.estacionamento;

public class Estacionamento {

    private String nome;
    private String cnpj;
    private Endereco endereco;

    public Estacionamento(String nome, String cnpj, Endereco endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void imprimirDados() {
        System.out.println("Estacionamento: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + endereco.getRua() + ", " + endereco.getNumero() + " - " + endereco.getBairro());
        System.out.println("Cidade: " + endereco.getCidade() + " - " + endereco.getEstado());
        System.out.println("CEP: " + endereco.getCep());
    }

    public String getEnderecoCompleto() {
        return endereco.getEnderecoCompleto();
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
