<script>
export default {
    data() {
        return {
            produto: '',
            produtos: []
        };
    },
    methods: {
        adicionarProduto() {
            if (this.produto.trim()) {
                this.produtos.push(this.produto);
                this.produto = '';
            }
        }
    }
}
</script>

<template>
    <h1>Clientes</h1>
    <label>Adicionar cliente</label>
    <input v-model="produto" type="text" id="inputProduto" />
    <button type="submit" @click="adicionarProduto">Adicionar</button>

    <ul>
        <li v-for="(item, index) in produtos" :key="index">
            {{ item }}
        </li>
    </ul>
</template>

<style>
label {
    margin-right: 15px;
    margin-left: 15px;
}
</style>
