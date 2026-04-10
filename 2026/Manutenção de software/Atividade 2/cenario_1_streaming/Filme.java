public class Filme {
    private String codigo;
    private String titulo;
    private int licencasDisponiveis;
    private double precoBase;

    public Filme(String codigo, String titulo, int licencasDisponiveis, double precoBase) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.licencasDisponiveis = licencasDisponiveis;
        this.precoBase = precoBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public boolean temLicencasDisponiveis() {
        return licencasDisponiveis > 0;
    }

    public void reduzirLicenca() {
        licencasDisponiveis--;
    }
}
