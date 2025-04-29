<template>
  <!-- Overlay -->
  <transition name="fade">
    <div v-if="isOpen" class="fixed inset-0 bg-opacity-30 backdrop-blur-sm" @click="store.close"></div>
  </transition>
  <div class="relative z-50 inline-block text-left min-w-[210px]">
    <!-- Кнопка -->
    <button @click="toggleDropdown" :class="[
      'inline-flex justify-between items-center w-full px-4 py-2 border bg-white hover:bg-gray-100 focus:ring-1 focus:ring-blue-500 text-s font-medium',
      isOpen ? 'rounded-t-2xl rounded-b-none' : 'rounded-full'
    ]">
      <span>{{ selected }}</span>
      <ChevronDownIcon class="w-4 h-4 ml-2 transition-transform duration-300 ease-in-out"
        :class="{ 'rotate-180': isOpen }" />
    </button>

    <!-- Выпадающий список -->
    <transition name="slide-fade">
      <div v-if="isOpen"
        class="absolute z-10 w-full bg-white border border-t-0 rounded-b-2xl shadow-lg overflow-hidden">
        <li v-for="option in options" :key="option" @click="selectOption(option)"
          class="flex items-center px-4 py-3 hover:bg-gray-100 cursor-pointer gap-3">
          <div class="relative w-5 h-5">
            <div class="absolute inset-0 rounded-full border-2"
              :class="option === selected ? 'border-blue-600' : 'border-gray-400'"></div>
            <div v-if="option === selected" class="absolute inset-1 bg-blue-600 rounded-full"></div>
          </div>
          <span :class="option === selected ? 'text-gray-900 font-semibold' : 'text-gray-600 font-medium'"
            class="text-sm">
            {{ option }}
          </span>
        </li>
      </div>
    </transition>
  </div>
</template>

<script setup lang="ts">
import { ref, defineProps, defineEmits, computed, onMounted, onUnmounted } from 'vue';
import { useDropdownStore } from '@/stores/dropdownStore';
import { ChevronDownIcon } from 'lucide-vue-next';

const store = useDropdownStore();
const props = defineProps<{
  options: string[];
  modelValue?: string;
  storeName: string;
}>();

const emit = defineEmits<{
  (e: 'update:modelValue', value: string): void;
}>();

const selectOption = (option: string) => {
  selected.value = option;
  emit('update:modelValue', option);
  store.close();
};

const isOpen = computed(() => store.isActive(props.storeName));
const selected = ref(props.modelValue || props.options[0]);

const toggleDropdown = (event: MouseEvent) => {
  event.stopPropagation();
  if (store.isActive(props.storeName)) {
    store.close();
  } else {
    store.open(props.storeName);
  }
};

onMounted(() => {
  window.addEventListener('click', closeDropdown);
});

onUnmounted(() => {
  window.removeEventListener('click', closeDropdown);
});

const closeDropdown = () => {
  store.close();
};

</script>

<style scoped>
.slide-fade-enter-active,
.slide-fade-leave-active {
  transition: all 0.3s ease;
  transform-origin: top center;
}

.slide-fade-enter-from,
.slide-fade-leave-to {
  opacity: 0;
  transform: scaleY(0.8);
}
</style>
