package Lista1EX3;

public class Main {
    public static void main(String[] args) {
        Desenvolvedor dev = new Desenvolvedor("Enzo");
        ConsultorExterno consultor = new ConsultorExterno();

        dev.trabalharDeCasa();
        consultor.trabalharDeCasa();
    }
}
