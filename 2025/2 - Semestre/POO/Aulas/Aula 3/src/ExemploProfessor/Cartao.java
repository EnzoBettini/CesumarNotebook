package ExemploProfessor;

public class Cartao {
    String codigo;
    String cvv;
    String validade;
    ContaBancaria contaBancaria;

    Cartao(String codigo, String cvv, String validade, ContaBancaria contaBancaria) {
        this.codigo = codigo;
        this.cvv = cvv;
        this.validade = validade;
        this.contaBancaria = contaBancaria; //agregação
    }
}
