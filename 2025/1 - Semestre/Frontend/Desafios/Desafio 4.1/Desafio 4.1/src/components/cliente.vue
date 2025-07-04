<script setup>
import { ref } from 'vue'

const clientes = ref([])
const nome = ref('')
const idade = ref('')

function adicionarCliente() {
  clientes.value.push({
    nome: nome.value,
    idade: idade.value,
  })

  nome.value = ''
  idade.value = ''
}
</script>

<template>
  <div class="container border mt-4 p-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
      <h1>Clientes</h1>
      <button class="btn btn-success" @click="adicionarCliente">Adicionar</button>
    </div>

    <div class="row mb-3">
      <div class="col">
        <input
          type="text"
          v-model="nome"
          class="form-control"
          placeholder="Nome do cliente"
        />
      </div>
      <div class="col">
        <input
          type="number"
          v-model="idade"
          class="form-control"
          placeholder="Idade"
        />
      </div>
    </div>

    <div class="card">
      <div class="card-body">
        <table class="table table-striped">
          <thead class="table-light">
            <tr>
              <th>Nome</th>
              <th>Idade</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(cliente, index) in clientes" :key="index">
              <td>{{ cliente.nome }}</td>
              <td>{{ cliente.idade }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
