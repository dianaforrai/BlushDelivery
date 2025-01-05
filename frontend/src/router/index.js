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
import DeletePackages from '../components/DeletePackages.vue'

const routes = [
  { path: '/', component: Home, meta: { requiresAuth: true } },
  { path: '/home', component: Home, meta: { requiresAuth: true } },
  { path: '/view-packages', component: ViewPackages, meta: { requiresAuth: true } },
  { path: '/available-packages', component: AvailablePackages, meta: { requiresAuth: true } },
  { path: '/add-package', component: AddPackages, meta: { requiresAuth: true } },
  { path: '/deliver-package', component: DeliverPackages, meta: { requiresAuth: true } },
  { path: '/login', component: Login },
  { path: '/register', component: Register },
  { path: '/assign-package', component: AssignPackage, meta: { requiresAuth: true } },
  { path: '/set-manager', component: SetManager, meta: { requiresAuth: true } },
  { path: '/delete-packages', component: DeletePackages, meta: { requiresAuth: true } }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth) && !localStorage.getItem('user-token')) {
    next('/login');
  } else {
    next();
  }
});

export default router
