<template>
  <div class="container-fluid login-container">
    <form class="main-form">
      <h1 class="text-center">Login</h1>
      <div class="mb-3">
        <label for="inputEmail" class="form-label">Email</label>
        <input v-model="email" type="email" class="form-control" id="inputEmail" required>
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input v-model="password" type="password" class="form-control" id="inputPassword" aria-describedby="pwHelp"
          required>
        <div id="pwHelp" class="form-text">We'll never share your password with anyone else.</div>
      </div>
      <button @click="login($event)" type="submit" class="btn btn-primary">Login</button>
      <p class="create-account-info">Don't have an account? <router-link to="/register">Register</router-link></p>
    </form>
    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="true"
      :class="{ 'show': showToast }" style="position: absolute; top: 0; right: 0;">
      <div class="toast-header">
        <strong class="me-auto">Notification</strong>
        <button type="button" class="m1-2 mb-1 btn-close" @click="showToast = false"></button>
      </div>
      <div class="toast-body">
        {{ toastMessage }}
      </div>
    </div>

  </div>
</template>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 95vh;
}
</style>

<script>
import axios from 'axios';
export default {
  name: 'Login',
  props: {
    msg: String
  },
  data() {
    return {
      email: '',
      password: '',
      showToast: false,
      toastMessage: ''
    };
  },
  methods: {
    login(event) {
      event.preventDefault();
      if (this.email === '' || this.password === '') {
        this.toastMessage = 'Please fill in all fields!';
        this.showToast = true;

        setTimeout(() => {
          this.showToast = false;
        }, 5000);

        return;
      }
      axios.post('http://localhost:8083/couriers/login', {
        email: this.email,
        password: this.password
      })
        .then(response => {
          console.log(response);
          if (response.data.id) {
            // The registration was successful
            localStorage.setItem('user-token', `token${response.data.id}`);
            this.$router.push('/home');
          }
        })
        .catch(error => {
          console.log(error.response);
          this.toastMessage = 'Invalid registration: ' + error.response.data.error;
          this.showToast = true;

          setTimeout(() => {
            this.showToast = false;
          }, 5000);
        });
    },

  }
}
</script>