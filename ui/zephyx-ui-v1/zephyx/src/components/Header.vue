<template>
    <header class="flex items-center justify-between px-8 py-4 bg-gray-100 shadow">
        <Logo></Logo>
        <nav class="flex gap-6">
      <RouterLink to="/" class="hover:text-blue-500">Главная</RouterLink>
      <RouterLink to="/search" class="hover:text-blue-500">Поиск</RouterLink>
      <RouterLink to="/checkout" class="hover:text-blue-500">Корзина</RouterLink>
    </nav>
    </header>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router';
import Logo from '@/components/Logo.vue';
</script>