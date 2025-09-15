import Classes.Hospede;
import Classes.Hotel;

public class Main {
    public static void main(String[] args) {
        Hospede hospede = new Hospede("Enzo", "123");

        Hotel hotel = new Hotel("Hotel Cesumar", "rua lagosta 111");

        hotel.adicionarQuarto(123, "Solteiro", 10.00);
        hotel.adicionarQuarto(124, "casal", 15.00);

        hotel.hospedar(hospede, 123);

        hotel.exibirRelatório();
    }
}
