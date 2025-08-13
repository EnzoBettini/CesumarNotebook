package MeuExemplo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public double id;
    public double quantidade;
    public double valor_total;
    public Cliente cliente;
    public List<Produto> produtos;

    public Pedido(double id, double quantidade, double valor_total, Cliente cliente) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }
}

