package Sistema;

public class Quarto {
    private String tipo;
    private int numero;
    private Double precoPorNoite;
    private Boolean ocupado;
    private Hospede hospede;

    Quarto(int numero, String tipo, Double precoPorNoite){
        this.numero = numero;
        this.tipo = tipo;
        this.precoPorNoite = precoPorNoite;
        this.ocupado = false;
    }

    public void ocupar(Hospede hospede){
        this.hospede = hospede;
        this.ocupado = true;
    }

    public void liberar() {
        this.ocupado = false;
        this.hospede = null;
    }

    public  Boolean isOcupado(){
        return this.ocupado;
    }

    public String getTipo() {
        return tipo;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public int getNumero() {
        return numero;
    }
}
