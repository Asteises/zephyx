<script setup lang="ts">
import { defineProps } from 'vue';
import { RouterLink } from 'vue-router';
import defaultLogo from '@/assets/zephyx_logo_1.png'

const props = defineProps<{
    src?: string;
    alt?: string;
    height?: string;
}>();

</script>

<template>
    <RouterLink to="/" class="flex items-center">
        <img
            :src="props.src || defaultLogo"
            alt="props.src || 'Zephyx Logo'"
            :class="['object-contain', props.height || 'h-10', 'w-auto', 'max-w-[160px]']">
    </RouterLink>
</template>