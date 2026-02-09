package Lista1Ex2;

public class ArCondicionado implements DispositivoEletronico {
    @Override
    public void ligar() {
        System.out.println("Ar condicionado ligado!");
    }

    @Override
    public void desligar() {
        System.out.println("Ar condicionado desligado!");
    }
}
