package Lista1Ex7;

public class Usuario implements ExportavelCSV {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toCSV() {
        return nome + ";" + email;
    }
}
