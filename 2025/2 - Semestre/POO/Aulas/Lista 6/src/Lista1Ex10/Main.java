package Lista1Ex10;

public class Main {
    public static void main(String[] args) {
        Heroi heroi = new Heroi("Arthas", 10);
        Inimigo inimigo = new Inimigo("Goblin", 5);
        PocaoDeInvisibilidade pocao = new PocaoDeInvisibilidade();

        heroi.atacar();
        inimigo.atacar();
        heroi.ficarInvisivel();
        pocao.ficarInvisivel();
    }
}
