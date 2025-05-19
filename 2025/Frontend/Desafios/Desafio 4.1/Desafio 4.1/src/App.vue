<script setup>
import { ref } from 'vue'
import navbar from './components/navbar.vue'
import cliente from './components/cliente.vue'
import produto from './components/produto.vue'

const seletor = ref('cliente')
</script>

<template>
  <navbar :seletor = "seletor" @mudar-seletor="seletor = $event" />
  <cliente v-if="seletor === 'cliente'" />
  <produto v-if="seletor === 'produto'" />
</template>
