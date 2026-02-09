package Lista2Ex1;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Sedan", 200.0);
        Moto moto = new Moto("Esportiva", 150.0);

        System.out.println("Seguro do carro: R$ " + carro.calcularSeguro());
        System.out.println("Seguro da moto: R$ " + moto.calcularSeguro());
    }
}

