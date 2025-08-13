package MeuExemplo;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    public double id;
    public String nome;
    public double estoque;
    public double valor_unitario;
    public List<Pedido> pedidos;

    public Produto(double id, String nome, double estoque, double valor_unitario) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.valor_unitario = valor_unitario;
        this.pedidos = new ArrayList<>();
    }
}


