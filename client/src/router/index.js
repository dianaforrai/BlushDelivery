import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import AvailableCouriers from '../components/AvailableCouriers.vue';


const routes = [
  { path : '/', component : Home },
  { path : '/home', component : Home },
  { path : '/available-couriers', component : AvailableCouriers }
  
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router
