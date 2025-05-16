<script setup>
defineProps({
  seletor: String
})
</script>

<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Gerenciamento</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" aria-current="page" href="#" :class="{ active: seletor === 'produto' }" @click.prevent="$emit('mudar-seletor', 'produto')">Produtos</a>
                <a class="nav-link" href="#" :class="{ active: seletor === 'cliente' }" @click.prevent="$emit('mudar-seletor', 'cliente')">Clientes</a>
            </div>
        </div>
    </div>
    </nav>
</template>
