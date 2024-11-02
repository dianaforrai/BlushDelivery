<template>
    <div>
        <button @click="start()" class="btn-start"> <i class="fa-solid fa-right-from-bracket"></i>Available Couriers</button>
        <button @click="start2()" class="btn-start2"> <i class="fa-solid fa-right-from-bracket"></i>Managers and Packages</button>
        <button @click="start3()" class="btn-start3"> <i class="fa-solid fa-right-from-bracket"></i>Send Notification to Selected Users</button>

        
    </div>
</template>

<script>
export default {
      name: 'Home',
      methods: {
    start() {
      this.$router.push('/available-couriers');
    },
    start2() {
      this.$router.push('/managers-and-packages');
    },
    start3() {
      this.$router.push('/send-notification');
  }
    }
}
</script>
<style scoped>
    .btn-start:hover {
      transform: translateY(-5px);
    }
    
    .main-navigation li {
      color: rgb(172, 72, 89); /* Change this to your desired color */
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
    .btn-start2:hover {
      transform: translateY(-5px);
    }
    
    .main-navigation li {
      color: rgb(172, 72, 89); /* Change this to your desired color */
    }
    
    .btn-start2 {
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
    .btn-start3:hover {
      transform: translateY(-5px);
    }
    
    .main-navigation li {
      color: rgb(172, 72, 89); /* Change this to your desired color */
    }
    
    .btn-start3 {
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