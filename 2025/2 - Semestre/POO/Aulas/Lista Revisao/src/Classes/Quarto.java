package Classes;

public class Quarto {
    private int numero;
    private String tipo;
    private double precoPorNoite;
    private boolean ocupado;
    private Hospede hospedeAtual;

    public Quarto(int numero, String tipo, double precoPorNoite) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoPorNoite = precoPorNoite;
        this.ocupado = false;
        this.hospedeAtual = null;
    }

    public void ocupar(Hospede hospede){
        if (hospede == null){
            System.out.println("Erro ao adicionar hóspede, não criado, crie um hóspede antes!");
            System.out.println();
        } else {
            this.hospedeAtual = hospede;
            this.ocupado = true;
            System.out.println("O quarto foi ocupado");
            System.out.println();
        }
    }

    public void liberar(){
        if (ocupado){
            System.out.println("O quarto não tem ninguem para ser liberado!");
        } else {
            this.hospedeAtual = null;
            this.ocupado = false;
            System.out.println("O quarto foi liberado");
        }
    }

    public boolean isOcupado(){
        return this.ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }
}
