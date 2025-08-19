public class Main {
    public static void main(String[] args) {

        Cachorro meg = new Cachorro("Meg", 12, "Enzo", 11111);

        Pessoa jonas = new Pessoa("Jonas", 1111);

        Banho pronto = new Banho("Protex", 20, jonas, meg);

       pronto.mostrarDados();
    }
}
