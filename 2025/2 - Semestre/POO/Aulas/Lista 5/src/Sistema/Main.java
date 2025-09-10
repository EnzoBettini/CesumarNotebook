package Sistema;

public class Main {
    public static void main(String[] args) {
        Hospede hospede = new Hospede("Enzo", "123");

        Hotel hotel = new Hotel("Bristol", "Avenida 123");

        hotel.adicionarQuarto("Suite", 2, 20.00);
        hotel.adicionarQuarto("Simples", 3, 10.00);

        hotel.hospedar(hospede, 2);

        hotel.checarHospedes();

        hotel.realizarCheckout(2);
    }
}
