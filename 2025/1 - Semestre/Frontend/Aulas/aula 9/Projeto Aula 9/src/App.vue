<script>
export default {
  data() {
    return {
      pessoas: [], // Array que armazenará as pessoas adicionadas
      nome: '', // Variável para armazenar o nome digitado pelo usuário
      idade: '', // Variável para armazenar a idade digitada pelo usuário
      sexo: '', // Variável para armazenar o sexo digitado pelo usuário
    };
  },
  methods: {
    adicionar() {
      // Adiciona um novo objeto pessoa ao array com os dados inseridos
      this.pessoas.push({ nome: this.nome, idade: this.idade, sexo: this.sexo });

      // Limpa os campos de entrada após adicionar a pessoa
      this.nome = '';
      this.idade = '';
    },
  },
};
</script>

<template>
  <div class="container">
    <div class="d-flex justify-content-between mt-4">
      <h1>Pessoas</h1>
      <input
        type="button"
        value="Add"
        class="btn btn-primary"
        data-bs-toggle="modal" <!-- Define que ao clicar, o modal será aberto -->
        data-bs-target="#exampleModal" <!-- Define que ao clicar, o modal será aberto -->
      />
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1" <!-- Define que o modal pode ser focado quando aberto -->
      aria-labelledby="exampleModalLabel" <!-- Acessibilidade: define qual elemento descreve o modal -->
      aria-hidden="true" <!-- Indica que o modal está invisível por padrão -->
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Adicionar Pessoas</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal" <!-- Permite que o modal seja fechado ao clicar -->
              aria-label="Close" <!-- Melhora a acessibilidade para leitores de tela -->
            ></button>
          </div>

          <div class="modal-body">
            <label for="" class="form-label">Nome:</label>
            <input v-model="nome" placeholder="Nome" class="form-control" />

            <label for="" class="form-label">Idade:</label>
            <input v-model="idade" placeholder="Idade" class="form-control" />
          </div>

          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal" <!-- Fecha o modal ao clicar -->
            >Fechar</button>
            <button
              type="button"
              class="btn btn-primary"
              @click="adicionar" <!-- Chama o método adicionar() ao clicar -->
            >Salvar</button>
          </div>
        </div>
      </div>
    </div>

    <!-- Lista de Pessoas -->
    <div class="row mt-4"></div> <!-- Espaçamento entre elementos -->
    <div class="row mt-4"></div>
    <div class="row mt-4"></div>
    <div class="row mt-4"></div>
    <div class="row mt-4"></div>
    <div class="row mt-4"></div>

    <div v-if="pessoas.length === 0" class="d-flex justify-content-center">
      <img src="./assets/logo.sv" alt="" style="width: 20%;" /> <!-- Mostra imagem quando não há pessoas na lista -->
    </div>

    <div v-else class="d-flex justify-content-center">
      <table class="table">
        <thead>
          <tr>
            <th>Nome</th>
            <th>Idade</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="pessoa in pessoas" :key="pessoa.nome"> <!-- Loop para exibir todas as pessoas -->
            <td>{{ pessoa.nome }}</td>
            <td>{{ pessoa.idade }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
