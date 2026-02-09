package br.edu.unicesumar.ex3;

public class TarefaService {
    private final TarefaBanco database = new TarefaBanco();

    public void adicionarTarefa(String descricao) {
        var task = new Tarefa(descricao);
        database.inserirTarefa(task);
    }

    public void mostrarTarefas() {
        database.listarTodos();
    }

    public void mostrarTarefaPendente() {
        database.listarPendentes();
    }

    public void atualizarStatusTarefa(int id) {
        database.atualizarStatus(id);
    }

    public void excluirTarefa(int id) {
        database.removerTarefa(id);
    }
}
