<template>
  <div class="container-fluid register-container">
    <form class="main-form">
      <h1 class="text-center">Register</h1>
      <div class="mb-3">
        <label for="inputName" class="form-label">Name</label>
        <input v-model="name" type="text" class="form-control" id="inputName" required>
      </div>
      <div class="mb-3">
        <label for="inputEmail" class="form-label">Email</label>
        <input v-model="email" type="email" class="form-control" id="inputEmail" required>
      </div>
      <div class="mb-3">
        <label for="inputRepeatPassword" class="form-label">Password</label>
        <input v-model="repeatPassword" type="password" class="form-control" id="inputRepeatPassword"
          aria-describedby="pwHelp" required>
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">Repeat password</label>
        <input v-model="password" type="password" class="form-control" id="inputPassword" aria-describedby="pwHelp"
          required>
      </div>
      <div id="pwHelp" class="form-text">We'll never share your password with anyone else.</div>
      <button @click="register($event)" type="submit" class="btn btn-primary">Register</button>
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
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 95vh;
}
</style>

<script>
import axios from 'axios';
export default {
  name: 'UserRegistration',
  props: {
    msg: String
  },
  data() {
    return {
      name: '',
      email: '',
      password: '',
      repeatPassword: '',
      showToast: false,
      toastMessage: ''
    };
  },
  methods: {
    register(event) {
      event.preventDefault();
      if (this.email === '' || this.password === '' || this.repeatPassword === '') {
        this.toastMessage = 'Please fill in all fields!';
        this.showToast = true;

        setTimeout(() => {
          this.showToast = false;
        }, 5000);

        return;
      }

      if (this.password !== this.repeatPassword) {
        this.toastMessage = 'Passwords do not match!';
        this.showToast = true;

        setTimeout(() => {
          this.showToast = false;
        }, 5000);

        return;
      }

      axios.post('http://localhost:8083/couriers', {
        name: this.name,
        email: this.email,
        password: this.password,
        manager: null
      })
        .then(response => {
          console.log(response);
          if (response.data) {
            // The registration was successful
            this.$router.push('/login');
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
    }
  }
}


</script>