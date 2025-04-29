<template>
  <div>
    <Header></Header>
    <main class="p-4">
      <RouterView v-slot="{ Component }">
        <Transition name="fade" mode="out-in">
          <component :is="Component"> </component>
        </Transition>
      </RouterView>
    </main>
  </div>
</template>

<script setup lang="ts">
import Header from '@/components/Header.vue';
</script>

<style scoped>
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.4s ease;
}
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
</style>