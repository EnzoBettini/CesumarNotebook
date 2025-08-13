package ExemploProfessor;

public class Main {
    public static void main(String[] args) {

        ContaBancaria contaNubank = new ContaBancaria(10, "112345", "112",
                "Enzo", "11111111111", "28/10/2002");


        System.out.printf("nome: %s\n", contaNubank.titular.nome);
        System.out.printf("agencia: %s\n", contaNubank.agencia);


        Cartao cartaoNubank = new Cartao("11212121212", "333", "28/10/2002", contaNubank);

        System.out.printf("Nome titular: %s\n", cartaoNubank.contaBancaria.titular.nome);
        System.out.printf("num cartao: %s", cartaoNubank.codigo);
    }
}
