package br.edu.unicesumar.ex3;

public class Tarefa {
    private int id;
    private String descricao;
    private String status;

    public Tarefa(String descricao) { this.descricao = descricao; }

    public int getId() { return id; }

    public String getDescricao() { return descricao; }

    public String getStatus() { return status; }
}
