package Lista1EX3;

public class Desenvolvedor extends Funcionario implements TrabalhavelRemotamente {

    public Desenvolvedor(String nome) {
        super(nome);
    }

    @Override
    public void trabalharDeCasa() {
        System.out.println("Desenvolvedor trabalhando de casa...");
    }
}
