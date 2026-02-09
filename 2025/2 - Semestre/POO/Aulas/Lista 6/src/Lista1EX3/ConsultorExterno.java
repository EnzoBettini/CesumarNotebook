package Lista1EX3;

public class ConsultorExterno implements TrabalhavelRemotamente {
    @Override
    public void trabalharDeCasa() {
        System.out.println("Consultor trabalhando remotamente...");
    }
}
