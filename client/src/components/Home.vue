<template>
    <div class="button-container">
        <button @click="availableCouriers()" class="btn-primary"> <i class="fa-solid fa-right-from-bracket"></i>Available Couriers</button>
        <button @click="managersPackages()" class="btn-primary"> <i class="fa-solid fa-right-from-bracket"></i>Managers and Packages</button>
        <button @click="sendNotification()" class="btn-primary"> <i class="fa-solid fa-right-from-bracket"></i>Send Notification to Selected Users</button>

        
    </div>
</template>

<script>
export default {
      name: 'Home',
      methods: {
    availableCouriers() {
      this.$router.push('/available-couriers');
    },
    managersPackages() {
      this.$router.push('/managers-and-packages');
    },
    sendNotification() {
      this.$router.push('/send-notification');
  }
    }
}
</script>
<style scoped>
    .btn-primary:hover {
      transform: translateY(-5px);
      
    }
    
    .main-navigation li {
      color: rgb(172, 72, 89); /* Change this to your desired color */
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
      color: rgb(172, 72, 89); /* Change this to your desired color */
    }
    
    .lista {
      list-style-type: none;
      text-decoration: none;
    }
  
    
    .main-navigation li {
      color: rgb(172, 72, 89); /* Change this to your desired color */
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