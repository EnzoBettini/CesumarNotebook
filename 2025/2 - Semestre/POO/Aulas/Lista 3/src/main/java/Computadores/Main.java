package Computadores;

public class Main {
    public static void main(String[] args) {
        Processador processador = new Processador("Intel i7-10700K", 3.8);
        MemoriaRAM ram = new MemoriaRAM(16, "DDR4");

        Computador pc = new Computador(processador, ram);

        pc.adicionarPeriferico(new Periferico("Mouse"));
        pc.adicionarPeriferico(new Periferico("Teclado"));
        pc.adicionarPeriferico(new Periferico("Monitor"));

        pc.exibirDetalhes();
    }
}
