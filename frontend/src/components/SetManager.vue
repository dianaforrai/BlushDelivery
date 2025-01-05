<template>
  <div class="container-flowup">
    <div class="mb-3">
      <label for="type" class="form-label">Couriers</label>
      <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default"
        v-model="idCourier">
        <option value="" disabled>Select a courier...</option>
        <option v-for="courier in couriers" :key="courier.id" :value="courier.id"> {{ courier.email }} </option>
      </select>
    </div>
    <div class="mb-3">
      <label for="type" class="form-label">Managers</label>
      <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default"
        v-model="idManager">
        <option value="" disabled>Select a manager...</option>
        <option v-for="manager in managers" :key="manager.id" :value="manager.id"> {{ manager.email }} </option>
      </select>
    </div>
    <v-btn @click="updateManager" class="btn-set"> <i class="fa-solid fa-right-from-bracket"></i>Set</v-btn>
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
  name: 'SetManager',
  data() {
    return {
      couriers: [],
      managers: [],
      idCourier: '',
      idManager: '',
      showToast: false,
      toastMessage: ''
    }
  },
  created() {
    this.fetchCouriers();
  },
  methods: {
    fetchCouriers() {
      axios.get(`http://localhost:8083/couriers`)
        .then(response => {
          console.log(response);
          this.couriers = response.data;
          this.managers = this.couriers;
        })
        .catch(error => {
          console.error(error);
        });
    },
    updateManager() {
      if (this.idCourier === '' || this.idManager === '') {
        this.toastMessage = 'Please select a courier and a manager!';
        this.showToast = true;
      } else {
        axios.put(`http://localhost:8083/couriers`, null, {
          params: {
            courierId: this.idCourier,
            managerId: this.idManager
          }
        })
          .then(response => {
            console.log(response);
            this.toastMessage = 'Manager updated successfully';

            this.showToast = true;
            setTimeout(() => {
              this.showToast = false;
            }, 5000);
          })
          .catch(error => {
            console.error(error);
            this.toastMessage = 'Failed to update manager: ' + (error.response?.data?.error || 'Unknown error');

            this.showToast = true;
            setTimeout(() => {
              this.showToast = false;
            }, 5000);
          })
          .finally(() => {
            this.idCourier = '';
            this.idManager = '';
          });
      }
    }
  }
};

</script>
<style scoped>
.btn-set:hover {
  transform: translateY(-5px);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-set {
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