<template>
  <div id="app">
    <nav v-if="$route.path !== '/login' && $route.path !== '/register'">
    <ul class = "lista">
      <li class="main-navigation"><RouterLink to="/"><span class="main-navigation">Home</span></RouterLink></li>
      <li class="main-navigation"><RouterLink to="/view-packages"><span class="main-navigation">View Packages</span></RouterLink></li>
      <li class="main-navigation"><RouterLink to="/available-packages"><span class="main-navigation">Available Packages</span></RouterLink></li>     
      <li class="main-navigation"> <RouterLink to="/add-package"><span class="main-navigation">Add Package</span></RouterLink></li>    
      <li class="main-navigation"><RouterLink to="/deliver-package"><span class="main-navigation">Deliver Package</span></RouterLink></li>
      <li class="main-navigation"><RouterLink to="/assign-package"><span class="main-navigation">Assign Package</span></RouterLink></li>
      <li class="main-navigation"><RouterLink to="/set-manager"><span class="main-navigation">Set Manager</span></RouterLink></li>
      <li class="main-navigation"><RouterLink to="/delete-packages"><span class="main-navigation">Delete Package</span></RouterLink></li>
    </ul>
    <button @click="logout()" class="btn-logout"> <i class="fa-solid fa-right-from-bracket"></i> Logout</button>
    </nav>
    <RouterView />
  </div>

</template>

<script>
export default {
  name: 'App',

  methods: {
     logout() {
            this.$router.push('/login');
        }
      }
}
</script>

<style scoped>
.btn-logout:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89); /* Change this to your desired color */
}

.btn-logout {
  position: absolute;
  top: 1rem;
  right: 1rem;
  background-color: var(--logout-color);
  color: var(--logout-color-text);
  border-color: var(--logout-color-text);
  border-radius: 1rem;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  cursor: pointer;
  font-weight: bold;
  box-shadow: 2px 2px 2px 1px var(--box-shadow-color);
  animation: slide-up-fade-in 1s ease;
  transition: transform 0.5s ease;
}
.lista {
  list-style-type: none;
  text-decoration: none;
}
</style>