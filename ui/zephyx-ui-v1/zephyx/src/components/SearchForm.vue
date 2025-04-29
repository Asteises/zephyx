<script setup lang="ts">
import PassengersBaggageDropdown from './PassengersBaggageDropdown.vue';
import SelectDropdown from './SelectDropdown.vue';

const tripTypes = ['Туда-обратно', 'В одну сторону', 'Составной маршрут', 'Nomad'];
const flightClassTypes = ['Эконом', 'Премиум-эконом', 'Бизнес', 'Первый класс'];

</script>

<template>
  <section class="bg-white rounded-2xl shadow p-6 max-w-5xl mx-auto mt-8">
    <div class="flex gap-2">
      <!-- Trip Types -->
      <div class="flex gap-4 mb-6">
        <SelectDropdown :options="tripTypes" :store-name="'select-trip-type'" />
      </div>

      <!-- Flight Class -->
      <div class="flex flex-wrap gap-4 mb-6">
        <SelectDropdown :options="flightClassTypes" :store-name="'select-flight-class'" />
      </div>

      <div class="flex">
        <PassengersBaggageDropdown></PassengersBaggageDropdown>
      </div>
    </div>

    <!-- Откуда / Куда -->
    <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6">
      <input type="text" placeholder="Откуда: Страна, Город или Аэропорт"
        class="border rounded-lg px-4 py-3 w-full focus:ring-2 focus:ring-blue-500" />
      <input type="text" placeholder="Куда: Любое направление"
        class="border rounded-lg px-4 py-3 w-full focus:ring-2 focus:ring-blue-500" />
    </div>

    <!-- Когда / Обратно -->
    <div class="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6">
      <input type="date" class="border rounded-lg px-4 py-3 w-full focus:ring-2 focus:ring-blue-500" />
      <input type="date" class="border rounded-lg px-4 py-3 w-full focus:ring-2 focus:ring-blue-500"
        placeholder="Обратно (если нужно)" />
    </div>

    <!-- Поиск -->
    <div class="flex justify-center">
      <button class="bg-blue-600 hover:bg-blue-700 text-white font-semibold px-8 py-4 rounded-full text-lg">
        Поиск
      </button>
    </div>
  </section>
</template>