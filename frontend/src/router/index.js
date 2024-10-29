import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import ViewPackages from '../components/ViewPackages.vue'
import AvailablePackages from '../components/AvailablePackages.vue'
import AddPackages from '../components/AddPackages.vue'
import DeliverPackages from '../components/DeliverPackages.vue'

const routes = [
  { path : '/', component : Home },
  { path : '/view-packages', component : ViewPackages },
  { path : '/available-packages', component : AvailablePackages },
  { path : '/add-package', component : AddPackages },
  { path : '/deliver-package', component : DeliverPackages }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router
