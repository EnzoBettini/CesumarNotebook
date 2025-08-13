package MeuExemplo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public String nome;
    public String cps;
    public List<Pedido> pedidos;

    public Cliente(String nome, String cps) {
        this.nome = nome;
        this.cps = cps;
        this.pedidos = new ArrayList<>();
    }
}
