<template>
  <header class="navbar">
    <div class="navbar-container">
      <NavbarLogo />
      <NavbarMenu />
      <div class="navbar-right">
        <NavbarCurrency />
        <NavbarAuth />
        <NavbarBurger />
      </div>
    </div>
  </header>
</template>

<script setup>
import NavbarLogo from './NavbarLogo.vue'
import NavbarMenu from './NavbarMenu.vue'
import NavbarAuth from './NavbarAuth.vue'
import NavbarCurrency from './NavbarCurrency.vue'
import NavbarBurger from './NavbarBurger.vue'
</script>

<style scoped>
.navbar {
  background-color: #003580;
  color: white;
  padding: 1rem 0;
}

.navbar-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 1rem;
}

.navbar-right {
  display: flex;
  align-items: center;
  gap: 1rem;
}
</style>
