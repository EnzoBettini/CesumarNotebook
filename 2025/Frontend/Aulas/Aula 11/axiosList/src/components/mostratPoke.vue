<script setup>
const props = defineProps(['nome', 'link']);
</script>
<template>
    <li> {{ nome }} --- {{ link }} </li>
</template>
