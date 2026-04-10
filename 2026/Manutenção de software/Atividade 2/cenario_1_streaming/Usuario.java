public class Usuario {
    private String id;
    private String nome;
    private String email;
    private boolean adimplente;

    public Usuario(String id, String nome, String email, boolean adimplente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.adimplente = adimplente;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdimplente() {
        return adimplente;
    }
}
