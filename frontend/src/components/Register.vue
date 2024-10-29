<template>
    <div class="container-fluid login-container">
      <form class="main-form">
        <h1 class="text-center">Register</h1>
        <div class="mb-3">
          <label for="inputUsername" class="form-label">Username</label>
          <input v-model="username" type="text" class="form-control" id="inputUsername" required>
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
  <script>

export default {
  name: 'UserRegistration',
  props: {
    msg: String
  },
  data() {
    return {
      username: '',
      password: '',
      repeatPassword: '',
      showToast: false,
      toastMessage: ''
    };
  },
  methods: {
    register(event) {
        event.preventDefault();
    },  
}
}

</script>