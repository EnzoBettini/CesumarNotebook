package br.edu.refactoring.estacionamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValorEstacionamento {

    private static final BigDecimal LIMITE_ALTO_VALOR = new BigDecimal("50.00");

    private final BigDecimal valor;

    public ValorEstacionamento(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String formatarReais() {
        return "R$ "
                + valor.setScale(2, RoundingMode.HALF_UP)
                       .toString()
                       .replace(".", ",");
    }

    public boolean isAltoValor() {
        return valor.compareTo(LIMITE_ALTO_VALOR) >= 0;
    }
}
