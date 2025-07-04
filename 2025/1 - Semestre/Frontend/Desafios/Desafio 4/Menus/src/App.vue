<script>
import navbar from './components/navbar.vue'
import produtos from './components/produtos.vue'
import clientes from './components/clientes.vue'
export default {
  components: {
    navbar,
    produtos,
    clientes
  },
  data() {
    return {
      seletor: '1'
    };
  }
}
</script>

<template>
  <main>
    <navbar :seletor="seletor" @mudar-seletor="seletor = $event" />
    <produtos v-if="seletor === '1'" />
    <clientes v-if="seletor === '2'" />
  </main>
</template>

<style scoped>

</style>
