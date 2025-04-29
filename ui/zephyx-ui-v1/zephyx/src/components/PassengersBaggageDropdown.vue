<template>
    <div class="relative z-50">
        <!-- Overlay -->
        <transition name="fade">
            <div v-if="isOpen" class="fixed inset-0 bg-opacity-30 backdrop-blur-sm" @click="store.close"></div>
        </transition>
        <div class="flex items-center gap-2 relative z-50">
            <!-- Первая кнопка -->
            <button @click="toggleDropdown" :class="[
                'inline-flex justify-between items-center w-full px-4 py-2 min-w-45 border bg-white hover:bg-gray-100 text-s font-medium',
                isOpen ? 'rounded-t-2xl rounded-b-none' : 'rounded-full'
            ]">
                <UserIcon class="w-4 h-4" />
                <span class="truncate">{{ totalPassengers }} Пассажиры</span>
                <ChevronDownIcon class="w-4 h-4 ml-1 transition-transform duration-300 ease-in-out"
                    :class="{ 'rotate-180': isOpen }" />
            </button>

            <!-- Вторая кнопка -->
            <button @click="toggleDropdown" :class="[
                'inline-flex justify-between items-center w-full px-4 py-2 min-w-35 border bg-white hover:bg-gray-100 text-s font-medium',
                isOpen ? 'rounded-t-2xl rounded-b-none' : 'rounded-full'
            ]">
                <BriefcaseBusiness class="w-4 h-4" />
                <span>{{ totalHandLuggage }}</span>
                <Luggage class="w-4 h-4" />
                <span>{{ totalCheckedBaggage }}</span>
                <ChevronDownIcon class="w-4 h-4 ml-1 transition-transform duration-300 ease-in-out"
                    :class="{ 'rotate-180': isOpen }" />
            </button>
        </div>

        <!-- Выпадающий блок -->
        <transition name="slide-fade">
            <div v-if="isOpen"
                class="absolute z-20 min-w-82 w-80 bg-white border border-t-0 rounded-b-2xl shadow-lg p-4" @click.stop>
                <!-- Пассажиры -->
                <h3 class="text-sm font-semibold text-gray-700 mb-3">Пассажиры</h3>
                <div v-for="(item, key) in passengers" :key="key" class="flex justify-between items-center py-2">
                    <div class="flex flex-col">
                        <span class="text-sm font-medium">{{ item.label }}</span>
                        <span class="text-xs text-gray-400">{{ item.description }}</span>
                    </div>
                    <div class="flex items-center gap-2">
                        <button @click="decrementPassenger(key)"
                            class="w-8 h-8 rounded-full bg-gray-100 hover:bg-gray-200 text-lg flex items-center justify-center"
                            :disabled="item.count === 0">-</button>
                        <span class="w-4 text-center">{{ item.count }}</span> <!-- Фикс ширины числа -->
                        <button @click="incrementPassenger(key)"
                            class="w-8 h-8 rounded-full bg-gray-100 hover:bg-gray-200 text-lg flex items-center justify-center"
                            :disabled="totalPassengers >= 9">+</button>
                    </div>
                </div>

                <!-- Багаж -->
                <h3 class="text-sm font-semibold text-gray-700 mt-4 mb-3">Багаж</h3>
                <div v-for="(item, key) in baggage" :key="key" class="flex justify-between items-center py-2">
                    <div class="flex flex-col">
                        <span class="text-sm font-medium">{{ item.label }}</span>
                    </div>
                    <div class="flex items-center gap-2">
                        <button @click="decrementBaggage(key)"
                            class="w-8 h-8 rounded-full bg-gray-100 hover:bg-gray-200 text-lg flex items-center justify-center"
                            :disabled="item.count === 0">-</button>
                        <span class="w-4 text-center">{{ item.count }}</span> <!-- Фикс ширины числа -->
                        <button @click="incrementBaggage(key)"
                            class="w-8 h-8 rounded-full bg-gray-100 hover:bg-gray-200 text-lg flex items-center justify-center">+</button>
                    </div>
                </div>
            </div>
        </transition>
    </div>
</template>

<script setup lang="ts">
import { ref, computed, onMounted, onUnmounted } from 'vue';
import { UserIcon, ChevronDownIcon, Luggage, BriefcaseBusiness } from 'lucide-vue-next';
import { useDropdownStore } from '@/stores/dropdownStore';

const store = useDropdownStore();
const isOpen = computed(() => store.isActive('passengers-baggage'));

onMounted(() => {
    window.addEventListener('click', closeDropdown);
});

onUnmounted(() => {
    window.removeEventListener('click', closeDropdown);
});

const closeDropdown = () => {
    store.close();
};

const passengers = ref({
    adults: { label: 'Взрослые', description: 'Старше 11 лет', count: 1 },
    children: { label: 'Дети', description: '2—11', count: 0 },
    infants: { label: 'Младенцы', description: 'до 2 лет', count: 0 },
});

const baggage = ref({
    hand: { label: 'Ручная кладь', count: 0 },
    checked: { label: 'Зарегистрированный багаж', count: 0 },
});

const toggleDropdown = (event: MouseEvent) => {
    event.stopPropagation();
    if (store.isActive('passengers-baggage')) {
        store.close();
    } else {
        store.open('passengers-baggage');
    }
};

const totalPassengers = computed(() =>
    passengers.value.adults.count + passengers.value.children.count + passengers.value.infants.count
);

const totalHandLuggage = computed(() => baggage.value.hand.count);
const totalCheckedBaggage = computed(() => baggage.value.checked.count);

const incrementPassenger = (key: keyof typeof passengers.value) => {
    if (totalPassengers.value < 9) {
        passengers.value[key].count++;
    }
};

const decrementPassenger = (key: keyof typeof passengers.value) => {
    if (passengers.value[key].count > 0) {
        passengers.value[key].count--;
    }
};

const incrementBaggage = (key: keyof typeof baggage.value) => {
    baggage.value[key].count++;
};

const decrementBaggage = (key: keyof typeof baggage.value) => {
    if (baggage.value[key].count > 0) {
        baggage.value[key].count--;
    }
};
</script>

<style scoped>
.slide-fade-enter-active,
.slide-fade-leave-active {
    transition: all 0.2s ease;
    transform-origin: top center;
}

.slide-fade-enter-from,
.slide-fade-leave-to {
    opacity: 0;
    transform: scaleY(0.9);
}

.fade-enter-active, .fade-leave-active {
  transition: opacity 0.3s ease;
}
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
</style>