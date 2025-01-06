import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import AvailableCouriers from '../components/AvailableCouriers.vue';
import AwbSearch from '@/components/AwbSearch.vue';


const routes = [
  { path : '/', component : Home },
  { path : '/home', component : Home },
  { path : '/available-couriers', component : AvailableCouriers },
  { path : '/search-package', component : AwbSearch }
  
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router
