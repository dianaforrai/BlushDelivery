<template>
  <div id="app">
    <nav v-if="$route.path !== '/login' && $route.path !== '/register'">
      <ul class="lista">
        <li class="main-navigation">
          <RouterLink to="/"><span class="main-navigation">Home</span></RouterLink>
        </li>
      </ul>
    </nav>
    <RouterView />
  </div>
</template>
