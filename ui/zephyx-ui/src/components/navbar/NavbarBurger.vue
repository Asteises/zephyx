<template>
  <button
    class="burger-menu"
    @click="$emit('toggle')"
    :aria-expanded="isOpen"
    aria-label="Меню"
  >
    <span class="burger-line top" :class="{ 'open': isOpen }"></span>
    <span class="burger-line middle" :class="{ 'open': isOpen }"></span>
    <span class="burger-line bottom" :class="{ 'open': isOpen }"></span>
  </button>
</template>

<script setup lang="ts">
defineProps({
  isOpen: {
    type: Boolean,
    default: false
  }
});

defineEmits(['toggle']);
</script>

<style scoped>
.burger-menu {
  background: none;
  border: none;
  cursor: pointer;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 5px;
  padding: 12px;
  z-index: 1001;
  width: 44px;
  height: 44px;
  position: relative;
}

.burger-line {
  display: block;
  width: 24px;
  height: 2px;
  background-color: #00796b;
  transition: all 0.3s ease;
  transform-origin: center;
  position: relative;
}

.burger-line.top.open {
  transform: translateY(7px) rotate(45deg);
}

.burger-line.middle.open {
  opacity: 0;
  transform: scaleX(0);
}

.burger-line.bottom.open {
  transform: translateY(-7px) rotate(-45deg);
}
</style>
