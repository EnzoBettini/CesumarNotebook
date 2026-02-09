package Abstração.ex1;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro(1, "audi", 18);
        Moto moto = new Moto(1, "honda");

        System.out.println(carro.getMarca());
        System.out.println(moto.getMarca());

        carro.CalcularPedagio();
        moto.CalcularPedagio();
    }
}
