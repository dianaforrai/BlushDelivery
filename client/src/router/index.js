import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import AvailableCouriers from '../components/AvailableCouriers.vue';
import AwbSearch from '@/components/AwbSearch.vue';
import ManagersAndPackages from '@/components/ManagersAndPackages.vue';


const routes = [
  { path : '/', component : Home },
  { path : '/home', component : Home },
  { path : '/available-couriers', component : AvailableCouriers },
  { path : '/search-package', component : AwbSearch },
  { path : '/managers-and-packages', component : ManagersAndPackages }
  
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router
