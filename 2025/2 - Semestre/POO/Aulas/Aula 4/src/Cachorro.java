public class Cachorro {
    String nome;
    double peso;
    Pessoa dono;

    Cachorro(String nome, double peso, String nome_pessoa, int matricula) {
        this.nome = nome;
        this.peso = peso;
        this.dono = new Pessoa(nome_pessoa, matricula);
    }
}
