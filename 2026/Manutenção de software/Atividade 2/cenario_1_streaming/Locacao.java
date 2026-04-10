public class Locacao {
    private Usuario usuario;
    private Filme filme;
    private double valorCobrado;
    private boolean ativa;

    public Locacao(Usuario usuario, Filme filme, double valorCobrado, boolean ativa) {
        this.usuario = usuario;
        this.filme = filme;
        this.valorCobrado = valorCobrado;
        this.ativa = ativa;
    }
}
