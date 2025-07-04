<script setup>
import HelloWorld from "./components/HelloWorld.vue";
import TheWelcome from "./components/TheWelcome.vue";
</script>

<template>
  <div class="app">
    <nav class="navbar">
      <div class="navbar-brand">
        <h1>Travel Planner</h1>
      </div>
    </nav>

    <main class="main-content">
      <router-view></router-view>
    </main>
  </div>
</template>

<style scoped>
.app {
  min-height: 100vh;
  background-color: #f5f5f5;
}

.navbar {
  background-color: #2c3e50;
  color: white;
  padding: 1rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.navbar-brand h1 {
  margin: 0;
  font-size: 1.5rem;
}

.main-content {
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
}
</style>
