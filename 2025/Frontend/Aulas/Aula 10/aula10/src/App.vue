<script setup>
import {ref} from 'vue'
import TextoTela from './components/textoTela.vue';
const publicacoes = ref([
  {
    titulo: "Título 1", data: "15/04/2025", texto: "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
  },
  {
    titulo: "Título 2", data: "15/04/2025", texto: "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
  },
  {
    titulo: "Título 3", data: "15/04/2025", texto: "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
  },
]);
</script>

<template>
  <div class="container">
    <div v-for="publicacao in publicacoes" :key="publicacao.id">
      <TextoTela
        :titulo = "publicacao.titulo"
        :data = "publicacao.data"
        :texto = "publicacao.texto"
      />
    </div>
  </div>
</template>
