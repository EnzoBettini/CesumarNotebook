package br.edu.refactoring.estacionamento;

public class DadosSeguro {

    private final String seguradora;
    private final String numeroApolice;
    private final String telefoneAssistencia;

    public DadosSeguro(String seguradora, String numeroApolice, String telefoneAssistencia) {
        this.seguradora = seguradora;
        this.numeroApolice = numeroApolice;
        this.telefoneAssistencia = telefoneAssistencia;
    }

    public String getDadosSeguroFormatados() {
        return seguradora + " | Apólice " + numeroApolice + " | Assistência " + telefoneAssistencia;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public String getTelefoneAssistencia() {
        return telefoneAssistencia;
    }
}
