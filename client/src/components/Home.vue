<template>
  <img src="../assets/blushdelivery.svg" alt="Blush Delivery logo" class="logo" style="width: 60%"/>
  <div class="button-container">
    <v-btn @click="availableCouriers()" class="btn-primary">
      <i class="fa-solid fa-right-from-bracket"></i>Available Couriers
    </v-btn>
    <v-btn @click="managersPackages()" class="btn-primary">
      <i class="fa-solid fa-right-from-bracket"></i>Managers and Packages
    </v-btn>
    <input type="text" class="awb-search" placeholder="Enter AWB" v-model="awb"/>
    <v-btn @click="searchPackage()" class="btn-primary">
      <i class="fa-solid fa-right-from-bracket"></i>Search package
    </v-btn>
  </div>

</template>

<script>
import logo from '../assets/blushdelivery.svg';

export default {
  name: 'Home',
  data() {
    return {
      awb: ''
    }
  },
  methods: {
    availableCouriers() {
      this.$router.push('/available-couriers');
    },
    managersPackages() {
      this.$router.push('/managers-and-packages');
    },
    searchPackage() {
      this.$router.push('/search-package');
    }

  }
}
</script>
<style scoped>
.awb-search {
  width: 50%;
  padding: 0.5rem;
  margin: 1rem;
  border-radius: 1rem;
  border: 1px solid lightpink;
}

.btn-primary:hover {
  transform: translateY(-5px);

}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-primary {
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
  margin-bottom: 15px;
}

.lista {
  list-style-type: none;
  text-decoration: none;
}


.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.lista {
  list-style-type: none;
  text-decoration: none;
}


.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.lista {
  list-style-type: none;
  text-decoration: none;
}

.button-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: 10rem;
}
</style>