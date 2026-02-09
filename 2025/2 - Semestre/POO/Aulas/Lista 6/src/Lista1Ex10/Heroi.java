package Lista1Ex10;

public class Heroi extends Personagem implements FicavelInvisivel {

    public Heroi(String nome, int nivel) {
        super(nome, nivel);
    }

    @Override
    public void ficarInvisivel() {
        System.out.println(getNome() + " ficou invisível!");
    }
}
