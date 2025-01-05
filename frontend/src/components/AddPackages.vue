<template>
  <div class="container container-flowup">
    <input type="text" class="form-control packages-input" v-model="currentPackage.awb" placeholder="Enter AWB" />
    <input type="text" class="form-control packages-input" v-model="currentPackage.deliveryAddress"
      placeholder="Enter delivery address" />
    <input type="text" class="form-control packages-input" v-model="currentPackage.packageEmail"
      placeholder="Enter package email" />
    <div class="form-check packages-input custom-checkbox">
      <label class="form-check-label" for="flexCheckDefault">Pay on delivery</label>
      <input class="form-check-input" type="checkbox" v-model="currentPackage.payOnDelivery" id="flexCheckDefault" />
    </div>
    <select class="form-control packages-input" v-model="currentPackage.status">
      <option value="" disabled>Select a status...</option>
      <option value="NEW">NEW</option>
      <option value="PENDING">PENDING</option>
      <option value="DELIVERED">DELIVERED</option>
    </select>
    <select class="form-control packages-input" v-model="currentPackage.courier">
      <option value="" disabled selected>Select a courier...</option>
      <option v-for="courier in couriers" :key="courier.id" :value="courier.id">
        {{ courier.name }} {{ courier.email }}
      </option>
    </select>
    <div className="maps-wrapper">
      <iframe width="100%" height="300px" loading="lazy" allowFullScreen
        :src="generateMapUrlFromAddress(currentPackage.deliveryAddress)"></iframe>
    </div>
    <v-btn @click="addPackage" class="btn-addpackage"> <i class="fa-solid fa-right-from-bracket"></i> Add
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
  name: 'AddPackages',
  props: {
    msg: String
  },
  data() {
    return {
      apiKey: import.meta.env.VITE_API_KEY,
      currentPackage: {
        id: null,
        awb: '',
        createdOn: null,
        deliveryAddress: '',
        packageEmail: '',
        payOnDelivery: false,
        status: '',
        courier: ''
      },
      couriers: [],
      showToast: false,
      toastMessage: ''
    };
  },
  created() {
    this.fetchCouriers();
  },
  methods: {

    fetchCouriers() {
      axios.get('http://localhost:8083/couriers')
        .then(response => {
          console.log(response);
          this.couriers = response.data;
        })
        .catch(error => {
          console.log(error);
          this.toastMessage = 'Invalid registration: ' + error.response.data.error;
          this.showToast = true;

          setTimeout(() => {
            this.showToast = false;
          }, 5000);
        });
    },

    addPackage() {
      console.log(this.currentPackage);
      if (this.currentPackage.awb === '' || this.currentPackage.deliveryAddress === '' || this.currentPackage.packageEmail === '' || this.currentPackage.status === '' || this.currentPackage.courier === null) {
        this.toastMessage = 'Please fill in all the fields!';
        this.showToast = true;

        setTimeout(() => {
          this.showToast = false;
        }, 5000);
        return;
      }

      this.currentPackage.createdOn = new Date().toISOString();
      var courier = this.couriers.find(courier => courier.id === this.currentPackage.courier);
      console.log("Inserting package...", this.currentPackage);
      axios.post(`http://localhost:8083/packages`, {
        awb: this.currentPackage.awb,
        createdOn: this.currentPackage.createdOn,
        deliveryAddress: this.currentPackage.deliveryAddress,
        packageEmail: this.currentPackage.packageEmail,
        payOnDelivery: this.currentPackage.payOnDelivery,
        status: this.currentPackage.status,
        courier: courier
      })
        .then(response => {
          console.log(response);
          this.toastMessage = 'Package inserted successfully!';
          this.showToast = true;

          setTimeout(() => {
            this.showToast = false;
          }, 5000);
        })
        .catch(error => {
          console.error(error);
          this.toastMessage = 'Failed to insert package: ' + (error.response?.data?.error || 'Unknown error');
          this.showToast = true;

          setTimeout(() => {
            this.showToast = false;
          }, 5000);
        });

      this.currentPackage = {
        id: null,
        awb: '',
        createdOn: null,
        deliveryAddress: '',
        packageEmail: '',
        payOnDelivery: false,
        status: '',
        courier: ''
      }
    },
    generateMapUrlFromAddress(address) {
      if (address) {
        return `https://www.google.com/maps/embed/v1/place?key=${this.apiKey}&q=${encodeURIComponent(address)}&zoom=10&maptype=roadmap`;
      }
      return '';
    },

  }
}
</script>

<style scoped>
.custom-checkbox {
  background-color: rgb(99, 44, 52);
  color: white;
  /* White text */
  border: none;
  padding: 10px 20px;
  cursor: pointer;
}

.custom-checkbox:active {
  background-color: rgb(99, 44, 52);
}

.main-navigation li {
  color: rgb(172, 72, 89);
  /* Change this to your desired color */
}

.btn-addpackage {
  position: relative;
  top: 2rem;
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

.packages-input:not(:last-child) {
  margin-bottom: 1rem;
}

.custom-checkbox {
  background-color: transparent;
  margin-left: 15%;
}

.custom-checkbox:active {
  background-color: transparent;
}

iframe {
  border-radius: 2rem;
  box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.4);
}
</style>