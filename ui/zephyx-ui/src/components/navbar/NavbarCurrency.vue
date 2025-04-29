<template>
  <div class="currency-selector" ref="dropdownRef">
    <div
      class="selected-currency"
      @click.stop="toggleDropdown"
      :class="{ 'active': isOpen }"
    >
      <span class="currency-code">{{ modelValue }}</span>
      <svg viewBox="0 0 24 24" width="16" height="16">
        <path fill="currentColor" d="M7 10l5 5 5-5z" />
      </svg>
    </div>

    <Transition name="fade">
      <div v-if="isOpen" class="currency-dropdown">
        <div
          v-for="currency in currencies"
          :key="currency"
          class="currency-option"
          :class="{ 'selected': currency === modelValue }"
          @click.stop="selectCurrency(currency)"
        >
          {{ currency }}
        </div>
      </div>
    </Transition>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, onBeforeUnmount } from 'vue';

const props = defineProps({
  modelValue: {
    type: String,
    required: true
  }
});

const emit = defineEmits(['update:modelValue']);

const isOpen = ref(false);
const dropdownRef = ref<HTMLElement | null>(null);
const currencies = ['RUB', 'USD', 'EUR', 'GBP', 'CNY'];

const toggleDropdown = () => {
  isOpen.value = !isOpen.value;
};

const selectCurrency = (currency: string) => {
  emit('update:modelValue', currency);
  isOpen.value = false;
};

const handleClickOutside = (event: MouseEvent) => {
  if (dropdownRef.value && !dropdownRef.value.contains(event.target as Node)) {
    isOpen.value = false;
  }
};

onMounted(() => {
  document.addEventListener('click', handleClickOutside);
});

onBeforeUnmount(() => {
  document.removeEventListener('click', handleClickOutside);
});
</script>

<style scoped>
.currency-selector {
  position: relative;
  width: 70px;
  flex-shrink: 0;
}

.selected-currency {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 6px;
  cursor: pointer;
  color: #00796b;
  font-weight: 600;
  padding: 8px 12px;
  border-radius: 4px;
  transition: all 0.2s;
  border: 1px solid transparent;
  background-color: white;
}

.selected-currency:hover {
  background-color: rgba(0, 121, 107, 0.1);
}

.selected-currency.active {
  border-color: #b2dfdb;
  background-color: white;
}

.currency-code {
  display: inline-block;
  width: 30px;
  text-align: center;
}

.currency-dropdown {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  background-color: white;
  border: 1px solid #b2dfdb;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  z-index: 100;
  margin-top: 4px;
}

.currency-option {
  padding: 8px 12px;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.2s;
}

.currency-option:hover {
  background-color: #e0f2f1;
}

.currency-option.selected {
  background-color: #b2dfdb;
  font-weight: 600;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.2s, transform 0.2s;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
  transform: translateY(-10px);
}
</style>
