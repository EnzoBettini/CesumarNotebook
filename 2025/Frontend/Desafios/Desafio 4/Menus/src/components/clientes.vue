<script>
export default {
  data() {
    return {
      cliente: '',
      clientes: []
    };
  },
  methods: {
    adicionarProduto() {
      if (this.cliente.trim()) {
        this.clientes.push(this.cliente);
        this.cliente = '';
      }
    }
  }
}
</script>

<template>
  <div class="header-bar">
    <h1>Clientes</h1>
    <button class="btn btn-primary" @click="adicionarProduto">Adicionar</button>
  </div>

  <div class="form-group">
    <label for="inputProduto">Adicionar cliente</label>
    <input v-model="cliente" type="text" id="inputProduto" class="form-control" />
  </div>

  <ul class="list-group m-3">
    <li v-for="(item, index) in clientes" :key="index" class="list-group-item">
      {{ item }}
    </li>
  </ul>
</template>

<style scoped>
.header-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 15px;
  margin-top: 15px;
}

h1 {
  margin: 0;
}

.form-group {
  margin: 15px;
}
</style>
