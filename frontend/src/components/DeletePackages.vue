<template>
  <div class="container-flowup">

    <div class="mb-3">
      <label for="type" class="form-label">Packages</label>
      <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default"
        v-model="id">
        <option value="" disabled selected>Select a package...</option>
        <option v-for="pack in packages" :key="pack.id" :value="pack.id"> {{ pack.awb, pack.deliveryAddress }} </option>
      </select>
    </div>
    <v-btn @click="deletePackage" class="btn-deletepackage"> <i class="fa-solid fa-right-from-bracket"></i>Delete
      Package</v-btn>
  </div>

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
</template>

<script>
import axios from 'axios';

export default {
  name: 'DeletePackages',
  data() {
    return {
      packages: [],
      id: '',
      showToast: false,
      toastMessage: ''
    }
  },
  created() {
    this.fetchPackages();
  },
  methods: {
    fetchPackages() {
      axios.get(`http://localhost:8083/packages`)
        .then(response => {
          console.log(response);
          this.packages = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    deletePackage() {
      console.log(this.id);
      if (this.id === '') {
        this.toastMessage = 'Please select a package to delete!';
        this.showToast = true;

        setTimeout(() => {
          this.showToast = false;
        }, 5000);

        return;
      }
      const userConfirmed = window.confirm('Are you sure you want to deliver this package?');

      if (!userConfirmed) {
        return
      };

      console.log(this.id);
      axios.delete(`http://localhost:8083/packages/${this.id}`)
        .then(response => {
          console.log(response);
          this.fetchPackages();
          this.toastMessage = 'Package deleted successfully!';
          this.showToast = true;

          setTimeout(() => {
            this.showToast = false;
          }, 5000);
        })
        .catch(error => {
          console.error(error);
          this.toastMessage = 'Failed to delete package: ' + (error.response?.data?.error || 'Unknown error');
          this.showToast = true;

          setTimeout(() => {
            this.showToast = false;
          }, 5000);
        });
    }
  }
}
</script>
<style scoped>
.btn-deletepackage:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-deletepackage {
  position: middle;
  top: 1rem;
  right: 1rem;
  background-color: rgb(172, 72, 89);
  color: white;
  border-color: lightpink;
  border-radius: 1rem;
  padding: 0.5rem 1rem;
  font-size: 1rem;
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