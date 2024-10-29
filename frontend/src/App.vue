<template>
  <div id="app">
    <nav> <ul>
      <li><RouterLink to="/">Home</RouterLink></li>
      <li><RouterLink to="/view-packages">View packages</RouterLink></li>
      <li><RouterLink to="/available-packages">Available packages</RouterLink></li>     
      <li> <RouterLink to="/add-package">Add package</RouterLink></li>    
      <li><RouterLink to="/deliver-package">Deliver package</RouterLink></li>
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