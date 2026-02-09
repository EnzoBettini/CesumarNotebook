package br.edu.unicesumar.ex2;

public class ClienteService {

    private ClienteBanco repository = new ClienteBanco();

    public void adicionarCliente(String nome, String email, String telefone) {
        Cliente client = new Cliente(nome, email, telefone);
        repository.inserirCliente(client);
    }

    public void mostrarClientes() {
        repository.listarTodos();
    }

    public void buscarClientePorEmail(String email) {
        repository.listarClientePorEmail(email);
    }

    public void atualizarTelefoneCliente(int id, String telefone) {
        repository.atualizarTelefone(id, telefone);
    }

    public void excluirCliente(int id) {
        repository.removerCliente(id);
    }
}
