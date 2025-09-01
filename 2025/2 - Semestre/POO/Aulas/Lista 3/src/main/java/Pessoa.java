public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void fazerAniversario() {
        idade++;
    }

    public void exibirIdade() {
        System.out.println(nome + " tem " + idade + " anos.");
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Enzo", 22);

        pessoa.exibirIdade();
        pessoa.fazerAniversario();
        pessoa.exibirIdade();
    }
}
