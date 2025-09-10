package Sistema;

public class Hospede {
    private String nome;
    private String cpf;

    Hospede(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
