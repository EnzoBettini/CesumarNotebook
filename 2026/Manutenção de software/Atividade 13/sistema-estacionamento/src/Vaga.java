package br.edu.refactoring.estacionamento;

public class Vaga {

    private String codigo;
    private String setor;
    private boolean coberta;
    private boolean ocupada;

    public Vaga(String codigo, String setor, boolean coberta, boolean ocupada) {
        this.codigo = codigo;
        this.setor = setor;
        this.coberta = coberta;
        this.ocupada = ocupada;
    }

    public String descreverStatus() {
        if (ocupada && coberta) {
            return "ocupada e coberta";
        }

        if (ocupada) {
            return "ocupada";
        }

        if (coberta) {
            return "livre e coberta";
        }

        return "livre";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSetor() {
        return setor;
    }

    public boolean isCoberta() {
        return coberta;
    }

    public boolean isOcupada() {
        return ocupada;
    }
}
