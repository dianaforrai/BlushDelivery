<template>
  <div class="container-flowup">
    <img :src="logo" class="logo">
    <v-btn @click="start()" class="btn-start"> <i class="fa-solid fa-right-from-bracket"></i>Let's Get
      Delivering</v-btn>

  </div>

</template>

<script>
import logo from '../assets/blushdelivery.svg';
export default {
  name: 'Home',
  data() {
    return {
      logo: logo
    };
  },
  methods: {
    start() {
      this.$router.push('/available-packages');
    }
  }
}
</script>
<style scoped>
.btn-start:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-start {
  position: middle;
  top: 1rem;
  right: 1rem;
  background-color: rgb(172, 72, 89);
  color: white;
  border-color: lightpink;
  border-radius: 1rem;
  padding: 0.5rem 1rem;
  font-size: 2rem;
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