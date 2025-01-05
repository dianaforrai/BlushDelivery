<template>
  <div class="container-flowup">
    <div class="mb-3">
      <label for="type" class="form-label">Couriers</label>
      <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default"
        v-model="idCourier">
        <option value="" disabled>Select a courier...</option>
        <option v-for="courier in couriers" :key="courier.id" :value="courier.id"> Email: {{ courier.email }}, Name: {{
          courier.name }} </option>
      </select>
    </div>
    <div class="mb-3">
      <label for="type" class="form-label">Packages</label>
      <select class="type-select form-control" aria-label="Type" aria-describedby="inputGroup-sizing-default"
        v-model="idPack">
        <option value="" disabled>Select a package...</option>
        <option v-for="pack in packages" :key="pack.id" :value="pack.id">AWB: {{ pack.awb }}, Address: {{
          pack.deliveryAddress }}</option>
      </select>
    </div>
    <v-btn @click="assignCourier" class="btn-set"> <i class="fa-solid fa-right-from-bracket"></i>Assign</v-btn>
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
      packages: [],
      couriers: [],
      idPack: '',
      idCourier: '',
      showToast: false,
      toastMessage: ''
    }
  },
  created() {
    this.fetchPackages();
    this.fetchCouriers();
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
    fetchCouriers() {
      axios.get(`http://localhost:8083/couriers`)
        .then(response => {
          console.log(response);
          this.couriers = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    },
    assignCourier() {
      console.log(this.idPack);
      console.log(this.idCourier);
      const currentPackage = this.packages.find(pack => pack.id === this.idPack);
      const currentCourier = this.couriers.find(courier => courier.id === this.idCourier);
      
      if (!currentPackage || !currentCourier) {
        this.toastMessage = 'Please select a package and a courier to assign!';
        this.showToast = true;
      } else {
        axios.put(`http://localhost:8083/packages/${currentPackage.id}`, {
            awb: currentPackage.awb,
            createdOn: currentPackage.createdOn,
            deliveryAddress: currentPackage.deliveryAddress,
            packageEmail: currentPackage.packageEmail,
            payOnDelivery: currentPackage.payOnDelivery,
            status: currentPackage.status,
            courier: currentCourier
        })
          .then(response => {
            console.log(response);
            this.toastMessage = 'Courier assigned successfully!';

            this.showToast = true;
            setTimeout(() => {
            this.showToast = false;
          }, 5000);
          })
          .catch(error => {
            console.error(error);
            this.toastMessage = 'An error occurred while assigning the courier!';

            this.showToast = true;
            setTimeout(() => {
            this.showToast = false;
          }, 5000);
          })
          .finally(() => {
            this.idPack = '';
            this.idCourier = '';
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