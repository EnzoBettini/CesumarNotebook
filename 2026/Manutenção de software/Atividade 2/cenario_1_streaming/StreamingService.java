public class StreamingService {
    private LocacaoRepository repo;
    private PagamentoGateway pagamentoGateway;
    private NotificadorEmail emailService;

    public StreamingService(LocacaoRepository repo,
                            PagamentoGateway pagamentoGateway,
                            NotificadorEmail emailService) {
        this.repo = repo;
        this.pagamentoGateway = pagamentoGateway;
        this.emailService = emailService;
    }

    public String processarLocacao(Usuario usuario,
                                   Filme filme,
                                   boolean cupomDesconto,
                                   boolean estreiaDaSemana,
                                   boolean perfilValidado) {

        if (usuario == null) {
            return "Usuário inválido";
        }
        if (filme == null) {
            return "Filme inválido";
        }
        if (repo.jaLocado(usuario.getId(), filme.getCodigo())) {
            return "Filme já locado pelo usuário";
        }
        if (!filme.temLicencasDisponiveis()) {
            return "Filme indisponível";
        }
        if (!perfilValidado) {
            return "Perfil não validado";
        }

        double valor = calcularValorFinal(filme, cupomDesconto, estreiaDaSemana);

        if (!usuario.isAdimplente()) {
            return "Usuário inadimplente";
        }
        if (!pagamentoGateway.cobrar(usuario, valor)) {
            return "Pagamento recusado";
        }

        concluirLocacaoComSucesso(usuario, filme, valor);
        return "Locação concluída";
    }

    private double calcularValorFinal(Filme filme, boolean cupomDesconto, boolean estreiaDaSemana) {
        double valor = filme.getPrecoBase();
        if (cupomDesconto) {
            valor = valor * 0.7;
        }
        if (estreiaDaSemana) {
            valor = valor + 12;
        }
        return valor;
    }

    private void concluirLocacaoComSucesso(Usuario usuario, Filme filme, double valor) {
        Locacao locacao = new Locacao(usuario, filme, valor, true);
        repo.salvar(locacao);
        emailService.enviarConfirmacao(usuario, filme);
        filme.reduzirLicenca();
    }
}
