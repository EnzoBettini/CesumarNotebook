# Atividade 16 — Gestão de Mudança em Software

Disciplina: Manutenção de Software  
Cenário escolhido: 1 (Plataforma de clínica médica)


## Etapa 1 — Compreensão e refinamento da solicitação

**Versão inicial interpretada**

A gerência pediu que, quando um paciente cancelar uma consulta, o sistema ofereça aquele horário para quem estiver na lista de espera, sem a recepção precisar fazer isso na mão.

**Perguntas de esclarecimento ao solicitante**

1. A lista de espera já existe no sistema ou teria que ser criada?
2. A vaga vai para um paciente de cada vez ou para vários ao mesmo tempo?
3. Quem tem prioridade na fila: quem entrou primeiro, quem tem mais urgência, ou quem está mais perto da data que queria?
4. O paciente precisa confirmar em um prazo? Se não responder, o que acontece?
5. A oferta vale só se bater especialidade e médico com o que a pessoa pediu na fila?
6. O aviso vai por SMS, e-mail ou os dois? A recepção também precisa ser notificada?

**Versão refinada**

Depois de pensar nas perguntas acima, a mudança ficou assim: quando uma consulta for cancelada (pelo paciente, pela clínica ou por falta), o sistema libera o horário na agenda e procura na lista de espera quem se encaixa naquele slot (mesma especialidade, mesmo profissional quando fizer sentido, data compatível). O primeiro da fila recebe uma notificação por SMS e/ou e-mail. Ele tem um prazo, por exemplo duas horas, para confirmar. Se confirmar, o sistema agenda e tira a pessoa da lista de espera. Se não confirmar ou recusar, passa para o próximo. Tudo isso fica registrado: quem cancelou, quem recebeu oferta, quem aceitou.

Se der erro (notificação falhou, fila vazia), o horário continua livre na agenda e a recepção encaixa manualmente como já faz hoje.


## Etapa 2 — Registro inicial da mudança

ID: CHG-001  
Título: Lista de espera automática para horários cancelados  
Origem: Gerência da clínica  
Descrição: Ao cancelar consulta, oferecer o horário automaticamente para pacientes em lista de espera, com notificação e confirmação.  
Motivação: Aproveitar melhor a agenda, diminuir trabalho da recepção e reduzir horários vazios.  
Status: Em análise


## Etapa 3 — Análise de impacto

Os módulos que mais sentem são agenda de consultas, lista de espera (que pode nem existir ainda), notificações e cadastro de pacientes. Relatórios administrativos podem ganhar indicadores depois, mas não é o foco agora.

No código, a gente imagina mexer no serviço de agendamento e cancelamento, criar ou ampliar um serviço de lista de espera, no envio de notificações e nas telas da recepção e do paciente. No banco, provavelmente entram tabelas ou campos para fila e ofertas pendentes. Também pode precisar de um job que roda de tempos em tempos para expirar ofertas que ninguém respondeu.

O módulo de agenda tem impacto alto porque muda a regra do cancelamento. A lista de espera também, porque é funcionalidade nova ou bem maior. Notificações é médio: novos textos de mensagem e outro fluxo de envio. Cadastro de pacientes é mais leitura de dados, risco baixo. Prontuário não muda direto. Faturamento pode complicar se a consulta cancelada já tiver sido cobrada, então marcamos como médio e deixamos para tratar com cuidado. Testes automatizados da agenda vão precisar de cenários novos.

Além do código, impacta interface, regra de negócio, persistência, comunicação com SMS/e-mail e integração com o provedor de mensagens.


## Etapa 4 — Identificação de riscos

**Oferta para o paciente errado.** Se o critério de matching estiver errado, agenda consulta na especialidade ou com o médico errado. Impacto alto. Mitigação: concentrar a regra num serviço só e testar com vários casos de fila.

**Dois pacientes no mesmo horário.** Se dois confirmarem quase ao mesmo tempo, dá conflito na agenda. Impacto alto. Mitigação: trancar o slot enquanto a oferta está aberta e usar transação na confirmação.

**Notificação duplicada.** O sistema já tem bug de lembrete repetido. A mudança nova usa o mesmo módulo. Impacto médio. Mitigação: corrigir o bug antes e garantir que o envio não dispare duas vezes.

**Paciente não responde e a vaga fica parada.** O horário não volta para a fila sozinho. Impacto médio. Mitigação: prazo de expiração e passar automaticamente para o próximo.

**Fila vazia.** A gerência pode achar que sempre vai preencher, mas nem sempre tem gente esperando. Impacto baixo. Mitigação: deixar claro no refinamento que o horário fica livre para encaixe manual.

**Quebrar o fluxo atual de agendar e cancelar.** Qualquer mudança na agenda pode afetar o que já funciona. Impacto alto. Mitigação: testes de regressão antes de subir.


## Etapa 5 — Priorização da mudança

Temos quatro demandas abertas além da nossa. Ordenamos assim:

**1º** Corrigir lembretes em duplicidade. Valor alto, urgência alta. Afeta todo mundo que tem consulta marcada. É relativamente rápido e a CHG-001 vai usar notificação; não faz sentido construir em cima de algo que já está bugado.

**2º** Lista de espera automática (CHG-001). Valor alto para a clínica, mas esforço e risco maiores. Fica na sequência depois do bug de SMS.

**3º** Lentidão na busca de paciente por nome. A recepção usa isso o tempo todo. Não é tão estratégico quanto a lista de espera, mas incomoda no dia a dia.

**4º** Melhorar PDF dos relatórios financeiros. É melhoria, não trava operação.

A justificativa é essa: bug que já incomoda usuário e bloqueia confiança no módulo de mensagens vem primeiro; depois a feature pedida pela gerência; depois performance; por último relatório bonito.


## Etapa 6 — Controle da mudança (registro consolidado)

ID: CHG-001  
Título: Lista de espera automática para horários cancelados  
Descrição refinada: Após cancelamento, buscar pacientes compatíveis na fila, notificar, aguardar confirmação com prazo, passar para o próximo se necessário e registrar tudo para auditoria.  
Prioridade: 2 (depois da correção dos lembretes duplicados)  
Status: Aprovada para planejamento  
Dependências: Correção das notificações duplicadas; gerência definir regra de prioridade da fila  
Módulos afetados: Agenda, lista de espera, notificações, cadastro de pacientes  
Responsáveis: Backend (regras e banco), frontend (telas), QA (cenários de fila)  
Versão prevista: 2.4.0  
Observação: Nesta entrega não mexemos em regra de faturamento. Consulta já cobrada e cancelada continua com tratamento manual.


## Etapa 7 — Rastreabilidade

A CHG-001 se liga às regras e aos artefatos assim:

Quando cancela consulta, libera o slot. Isso passa pelo CancelamentoConsultaService e AgendaRepository. Teste: testCancelamentoLiberaSlot.

Buscar quem está na fila com especialidade e horário compatíveis. ListaEsperaService e MatchingHorarioService. Teste: testMatchingListaEspera.

Ofertar para o primeiro elegível. OfertaVagaService. Teste: testOfertaPrimeiroDaFila.

Paciente confirma no prazo e vira agendamento. ConfirmacaoVagaService e AgendaService. Teste: testConfirmacaoCriaAgendamento.

Prazo estoura e vai para o próximo. ExpiracaoOfertaJob e OfertaVagaService. Teste: testExpiracaoPassaProximo.

Enviar notificação e gravar auditoria. NotificacaoService e AuditoriaRepository. Testes: testNotificacaoOferta e testRegistroAuditoria.

Recepção ver o status do horário na tela. Tela da agenda. Teste E2E de status aguardando confirmação.

A ideia é que cada regra de negócio tenha código e teste correspondente, para ninguém implementar uma coisa e validar outra.


## Etapa 8 — Planejamento inicial da implementação

Primeiro corrigir o envio duplicado de lembretes, porque a feature nova depende disso.

Depois ajustar o banco (tabelas de fila e oferta).

Em seguida implementar a lista de espera e a regra de matching, que dá para testar separado.

Aí ligar o cancelamento à oferta de vaga.

Implementar confirmação, recusa e o job que expira oferta sem resposta.

Atualizar as telas da recepção e do paciente.

Integrar os templates de notificação.

Por fim rodar regressão na agenda e no cancelamento manual.

Os pontos que mais pedem atenção na revisão: não deixar dois pacientes no mesmo horário, não mandar SMS duas vezes, e o job de expiração funcionar certo se tiver mais de um servidor rodando.


## Etapa 9 — Estratégia de validação da mudança

**Cenários funcionais**

Paciente cancela, primeiro da fila recebe oferta e confirma. Esperado: novo agendamento, sai da fila, uma notificação só.

Primeiro não responde no prazo. Esperado: oferta expira e o segundo recebe.

Cancelamento com fila vazia. Esperado: horário livre, sem erro, recepção agenda na mão.

SMS fora do ar. Esperado: tentativa registrada, e-mail como plano B se tiver, cancelamento não trava.

Paciente na fila de outra especialidade. Esperado: não recebe aquela oferta.

Agendar e cancelar como hoje, sem fila envolvida. Esperado: igual ao que já funciona.

**Regressão**

Agendamento, reagendamento e cancelamento pela recepção. Lembretes sem duplicidade. Busca de paciente e visualização da agenda.

**Critérios de aceite**

Horário cancelado vira oferta automática quando tem fila compatível. Só um paciente ocupa o slot depois da confirmação. Auditoria registra o fluxo. Nada crítico da agenda antiga quebrou.


## Etapa 10 — Reflexão final

A parte mais difícil foi refinar o pedido da gerência. Parece simples falar "oferecer para a lista de espera", mas na prática falta definir ordem da fila, prazo de resposta e o que fazer quando ninguém aceita.

O risco técnico ficou mais claro na análise de impacto. Não é só mandar um SMS: mexe em transação da agenda, no módulo de notificação que já tem problema, e pode dar corrida se duas pessoas responderem juntas.

Sem análise de impacto, a equipe poderia codar só o aviso e esquecer de travar o horário, de salvar a oferta no banco ou de olhar faturamento. O bug ia aparecer em produção sem ninguém ter mapeado antes.

Sem rastreabilidade, fica difícil saber qual teste cobre qual regra e o que já foi feito. Na manutenção isso vira retrabalho e regressão que ninguém percebe.

Gestão de mudança não é só implementar porque código sem entender o pedido, sem priorizar e sem planejar validação é trabalhar no escuro. Manutenção é processo: negócio, usuário, dependência entre módulos e ordem de entrega importam tanto quanto escrever a função.
