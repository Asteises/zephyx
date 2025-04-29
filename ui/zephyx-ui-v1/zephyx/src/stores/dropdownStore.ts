import { defineStore } from 'pinia';

export const useDropdownStore = defineStore('dropdown', {
  state: () => ({
    activeDropdown: '' as string,
  }),
  actions: {
    open(name: string) {
      this.activeDropdown = name;
    },
    close() {
      this.activeDropdown = '';
    },
    isActive(name: string) {
      return this.activeDropdown === name;
    },
  },
});
