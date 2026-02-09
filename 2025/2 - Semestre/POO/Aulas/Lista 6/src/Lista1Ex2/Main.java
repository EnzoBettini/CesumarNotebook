package Lista1Ex2;

public class Main {
    public static void main(String[] args) {
        Lampada lampada = new Lampada();
        ArCondicionado ar = new ArCondicionado();

        lampada.ligar();
        lampada.desligar();

        ar.ligar();
        ar.desligar();
    }
}
