package Lista1Ex2;

public class Lampada implements DispositivoEletronico {
    @Override
    public void ligar() {
        System.out.println("Lâmpada ligada!");
    }

    @Override
    public void desligar() {
        System.out.println("Lâmpada desligada!");
    }
}
