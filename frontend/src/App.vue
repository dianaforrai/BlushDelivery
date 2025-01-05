<template>
  <div id="app">
    <nav class="navbar" v-if="$route.path !== '/login' && $route.path !== '/register'">
      <ul class="nav-list">
        <li class="nav-item">
          <RouterLink to="/">Home</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/add-package">Add Package</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/delete-packages">Delete Package</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/view-packages">View Packages</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/available-packages">Available Packages</RouterLink>
        </li>

        <li class="nav-item">
          <RouterLink to="/deliver-package">Deliver Package</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/assign-package">Assign Package</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/set-manager">Set Manager</RouterLink>
        </li>
      </ul>
    </nav>
    <v-btn @click="logout()" class="btn-logout">
      <i class="fa-solid fa-right-from-bracket"></i> Logout
    </v-btn>
    <RouterView />
  </div>

</template>

<script>
export default {
  name: 'App',

  methods: {
    logout() {
      localStorage.removeItem('user-token');
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>
.navbar {
  padding-bottom: 50px;
}

.nav-list {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  font-size: 1.2rem;
}

.nav-item {
  padding: 14px 20px;
}

.nav-item a {
  color: white;
  text-align: center;
  text-decoration: none;
  display: block;
}

.nav-item a:hover {
  background-color: #ddd;
  color: rgb(172, 72, 89);
  border-radius: 10px;
}

.btn-logout:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
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