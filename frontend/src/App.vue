<template>
  <div id="app">
    <nav v-if="$route.path !== '/login' && $route.path !== '/register'">
    <ul>
      <li><RouterLink to="/">Home</RouterLink></li>
      <li><RouterLink to="/view-packages">View Packages</RouterLink></li>
      <li><RouterLink to="/available-packages">Available Packages</RouterLink></li>     
      <li> <RouterLink to="/add-package">Add Package</RouterLink></li>    
      <li><RouterLink to="/deliver-package">Deliver Package</RouterLink></li>
    </ul>
    </nav>
    <RouterView />
  </div>

</template>

<script>
export default {
  name: 'App',
}
</script>