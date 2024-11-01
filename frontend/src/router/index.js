import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import ViewPackages from '../components/ViewPackages.vue'
import AvailablePackages from '../components/AvailablePackages.vue'
import AddPackages from '../components/AddPackages.vue'
import DeliverPackages from '../components/DeliverPackages.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import AssignPackage from '../components/AssignPackage.vue'  
import SetManager from '../components/SetManager.vue'

const routes = [
  { path : '/', component : Home },
  { path : '/view-packages', component : ViewPackages },
  { path : '/available-packages', component : AvailablePackages },
  { path : '/add-package', component : AddPackages },
  { path : '/deliver-package', component : DeliverPackages },
  { path : '/login', component : Login },
  { path : '/register', component : Register },
  { path : '/assign-package', component : AssignPackage },
  { path : '/set-manager', component : SetManager }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router
