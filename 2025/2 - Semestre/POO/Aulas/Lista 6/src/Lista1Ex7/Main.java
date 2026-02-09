package Lista1Ex7;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Enzo Bettini", "enzo@email.com");
        Produto produto = new Produto("Notebook", 4500.00);

        System.out.println("Usuário CSV: " + usuario.toCSV());
        System.out.println("Produto CSV: " + produto.toCSV());
    }
}
